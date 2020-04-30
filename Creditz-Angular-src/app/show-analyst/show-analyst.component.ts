import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { AnalystService } from '../services/analyst.service';
import { UserService } from '../services/user.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-show-analyst',
  templateUrl: './show-analyst.component.html',
  styleUrls: ['./show-analyst.component.css']
})
export class ShowAnalystComponent implements OnInit {
  store = window.sessionStorage.getItem('userId');
  storeRole = window.sessionStorage.getItem('role');
  displayedColumns: string[] = ['userId','userEmail','actions'];
  
  @ViewChild(MatPaginator) paginator:MatPaginator;
  dataSource=new MatTableDataSource<any[]>();
  searchKey:String;
  length = 100;
  pageSizeOptions: number[] = [5, 10, 25, 100]
  pageEvent: PageEvent;
  pageIndex=0;
  pageNo=0;
  pageSize=5;
  setPageSizeOptions(setPageSizeOptionsInput: string) {
    if (setPageSizeOptionsInput) {
      this.pageSizeOptions = setPageSizeOptionsInput.split(',').map(str => +str);
    }
  }
  constructor(private analystservice:AnalystService,private userService:UserService) { }
   ngOnInit(){
      this.analystservice.findAllAnalyst().subscribe(stream=>
      {
       this.dataSource.data=stream as any;
       this.dataSource.paginator=this.paginator;

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
  deleteAnalyst(userEmail:any)
  {
       this.userService.deleteAnalyst(userEmail).subscribe(data=>
        {
        this.analystservice.findAllAnalyst().subscribe(stream=>
          {
           this.dataSource.data=stream as any;
           window.alert("Analyst Deleted");
    
          });
       
      }); 

    }
  }

