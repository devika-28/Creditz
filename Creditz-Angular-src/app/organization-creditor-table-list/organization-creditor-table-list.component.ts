import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSort } from '@angular/material/sort';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { OrganizationApplicationService } from '../services/organization-application.service';

@Component({
  selector: 'app-organization-creditor-table-list',
  templateUrl: './organization-creditor-table-list.component.html',
  styleUrls: ['./organization-creditor-table-list.component.css']
})
export class OrganizationCreditorTableListComponent implements OnInit {

  displayedColumns: string[] = ['applicationId','personName','contact','address','loanAmount','loanTenure','applicationStatus'];
  @ViewChild(MatSort) sort:MatSort;
  @ViewChild(MatPaginator) paginator:MatPaginator;
  dataSource=new MatTableDataSource<any[]>();
  searchKey:String;
  length = 1000;
  pageSizeOptions: number[] = [1,5, 10,20, 25,100,150,200]
  pageEvent: PageEvent;
  pageIndex=0;
  pageNo=0;
  pageSize=1;
 
  setPageSizeOptions(setPageSizeOptionsInput: string) {
  if (setPageSizeOptionsInput)
   {
      this.pageSizeOptions = setPageSizeOptionsInput.split(',').map(str => +str);
    }
  }
  constructor(private organizataionApplication:OrganizationApplicationService) { }
   ngOnInit(){
      this.organizataionApplication.findAllOrganizationApplication(this.pageNo,this.pageSize).subscribe(stream=>
       {
          this.dataSource.data=stream as any;
       });
      
  }
  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
  }

   ngAfterViewChecked()
  {
       this.pageSize=this.pageEvent.pageSize;
       this.pageNo=this.pageEvent.pageIndex;
       console.log(this.pageIndex+"check");
       this.organizataionApplication.findAllOrganizationApplication(this.pageIndex,this.pageSize).subscribe(stream=>
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