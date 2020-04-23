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

  store = window.sessionStorage.getItem('userId');
  constructor(private historyService: HistoryService) {  }
   
  dataSource = new MatTableDataSource(ELEMENT_DATA);
  displayedColumns = ['applicationId', 'loanAmount', 'loanTenure', 'applicationStatus'];

  @ViewChild(MatSort, {static: false}) sort: MatSort;

  ngOnInit() {

    this.historyService.showHistory(window.sessionStorage.getItem('userId'))
    .subscribe((history:History[])=>{
      history.forEach(i => {
        status='Pending'
        switch(i['applicationStatus']){
          case 'Rejected':
            status='Rejected'
            break;
          case 'Rejected Bad History':
            status='Rejected'
            break;  
          case 'Rejected Low Credits':
            status='Rejected'
            break; 
          case 'Approved':
            status='Approved'
            break;
          case 'Rejected Amount Declined':
            status='Rejected'
            break;
          case 'Pending Internal Error':
            status='Pending'
            break;
          case 'Record Not Found':
            status='Rejected'
            break;
          
        }
        var temp = {applicationId:i['applicationId'], loanAmount:i['loanAmount'], loanTenure:i['loanTenure'], applicationStatus:status, emailStatus:i['emailStatus']}
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