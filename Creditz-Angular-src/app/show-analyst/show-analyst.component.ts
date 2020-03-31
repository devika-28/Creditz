import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { AnalystService } from '../services/analyst.service';

@Component({
  selector: 'app-show-analyst',
  templateUrl: './show-analyst.component.html',
  styleUrls: ['./show-analyst.component.css']
})
export class ShowAnalystComponent implements OnInit {

  displayedColumns: string[] = ['userId','userEmail','actions'];
  
  @ViewChild(MatPaginator) paginator:MatPaginator;
  dataSource=new MatTableDataSource<any[]>();
 searchKey:String;
  length = 100;
  pageSizeOptions: number[] = [1,5, 10, 25, 100,150]
  pageEvent: PageEvent;
  pageIndex=0;
  pageNo=0;
  pageSize=10;
  setPageSizeOptions(setPageSizeOptionsInput: string) {
    if (setPageSizeOptionsInput) {
      this.pageSizeOptions = setPageSizeOptionsInput.split(',').map(str => +str);
    }
  }
  constructor(private analystservice:AnalystService) { }
   ngOnInit(){
      this.analystservice.findAllAnalyst(this.pageNo,this.pageSize).subscribe(stream=>
      {
       this.dataSource.data=stream as any;

      });
  }

   ngAfterViewChecked()
 {
      this.pageSize=this.pageEvent.pageSize;
      this.pageNo=this.pageEvent.pageIndex;
      console.log(this.pageIndex+"check");
      this.analystservice.findAllAnalyst(this.pageIndex,this.pageSize).subscribe(stream=>
       {
         this.dataSource.data=stream as any;
            console.log(this.pageIndex);
       });
   }


   applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }
 onSearchClear()
 {
  this.searchKey="";
  }
 
 }
