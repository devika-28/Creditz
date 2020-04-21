import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { HistoryService } from '../services/history.service';
import {MatSort, Sort} from '@angular/material/sort';
// import {History} from '../model/history';
import { BehaviorSubject } from 'rxjs';

export interface History {
  applicationId: bigint
  loanAmount: Number
  applicationStatus: String
  loanTenure: Number
  emailStatus: String
}

const ELEMENT_DATA: History[] = [];

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

  constructor(private historyService: HistoryService) {  }
   
  dataSource = new MatTableDataSource(ELEMENT_DATA);
  displayedColumns = ['applicationId', 'loanAmount', 'loanTenure', 'applicationStatus'];

  @ViewChild(MatSort, {static: false}) sort: MatSort;

  ngOnInit() {

    this.historyService.showHistory(window.sessionStorage.getItem('userId'))
    .subscribe((history:History[])=>{
      history.forEach(i => {
        var temp = {applicationId:i['applicationId'], loanAmount:i['loanAmount'], loanTenure:i['loanTenure'], applicationStatus:i['applicationStatus'], emailStatus:i['emailStatus']}
        ELEMENT_DATA.push(temp)
      });
    })

    this.dataSource.sort = this.sort;
    
    const sortState: Sort = {active: 'applicationId', direction: 'desc'};
    this.sort.active = sortState.active;
    this.sort.direction = sortState.direction;
    this.sort.sortChange.emit(sortState);

    // this.historyService.showHistory(window.sessionStorage.getItem('userId'));
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

}