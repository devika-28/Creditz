import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { HistoryService } from '../services/history.service';
import {MatSort} from '@angular/material/sort';
import {History} from '../model/history';


@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

  displayedColumns: string[] = ['applicationId', 'loanAmount', 'loanTenure', 'applicationStatus'];
  data = new Array(); 

  //data:History[]

  @ViewChild(MatSort, {static: true}) sort: MatSort;
  dataSource=new MatTableDataSource<any[]>();

  constructor(private historyService: HistoryService) {  }

  ngOnInit() {

    this.historyService.showHistory(window.sessionStorage.getItem('userId'))
    .subscribe(stream=>{
        this.dataSource.data=stream as any;
        console.log(stream)
})
    // .subscribe((history:History[])=>{
    //   console.log(history)
    //   var data = Array()
    //   history.forEach(i => {
    //     var temp = {applicationId:i['applicationId'], loanAmount:i['loanAmount'], loanTenure:i['loanTenure'], applicationStatus:i['applicationStatus'], emailStatus:i['emailStatus']}
    //     console.log(temp)
    //     data.push(temp)
    //   });
    //   console.log(typeof(data))
    //   this.data=data;
    // })


    this.dataSource.sort = this.sort;
    // this.historyService.showHistory(window.sessionStorage.getItem('userId'));

    
  }

}
