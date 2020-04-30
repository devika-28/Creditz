import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { Observable } from 'rxjs';
import { MatTableDataSource } from '@angular/material/table';
import { MatSortModule, MatSort, Sort } from '@angular/material/sort';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { OrganizationApplicationService } from '../services/organization-application.service';
import { PersonApplicant } from '../model/personapplicant';
@Component({
  selector: 'app-creditor-table-list',
  templateUrl: './creditor-table-list.component.html',
  styleUrls: ['./creditor-table-list.component.css']
})
export class CreditorTableListComponent implements OnInit {
  topPersons$: Observable<PersonApplicant>;
  public array:any;
  displayedColumns: string[] = ['applicationId','personName','contact','address','loanAmount','loanTenure','applicationDate','applicationStatus','emailStatus'];
  @ViewChild(MatSort) sort:MatSort;
  @ViewChild(MatPaginator) paginator:MatPaginator;
  dataSource=new MatTableDataSource<any[]>();
  searchKey:String;
  length = 1000;
  pageSizeOptions: number[] = [10,20, 25,100,150,200]
  pageEvent: PageEvent;
  pageIndex=0;
  pageNo=0;
  pageSize=10;
 
  setPageSizeOptions(setPageSizeOptionsInput: string) {
    if (setPageSizeOptionsInput) {
      this.pageSizeOptions = setPageSizeOptionsInput.split(',').map(str => +str);
    }
  }
  constructor(private organizataionApplication:OrganizationApplicationService) { }
   ngOnInit(){
      this.organizataionApplication.findAllIndividualApplication().subscribe(stream=>
       {
          this.dataSource.data=stream as any;
          this.dataSource.paginator=this.paginator;
       });
      
  }
  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
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