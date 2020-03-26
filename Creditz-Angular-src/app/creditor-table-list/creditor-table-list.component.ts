import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { Observable } from 'rxjs';
import { MatTableDataSource } from '@angular/material/table';
import { MatSortModule, MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { PersonService } from '../services/person.service';
@Component({
  selector: 'app-creditor-table-list',
  templateUrl: './creditor-table-list.component.html',
  styleUrls: ['./creditor-table-list.component.css']
})
export class CreditorTableListComponent implements OnInit {
  topPersons$: Observable<any>;
  displayedColumns: string[] = ['personId', 'personName', 'contact', 'address','actions'];
  @ViewChild(MatSort) sort:MatSort;
  @ViewChild(MatPaginator) paginator:MatPaginator;
  dataSource=new MatTableDataSource<any[]>();
  searchKey:String;
  constructor(private personService: PersonService) { }
  ngOnInit(){
  this.personService.findAllTopIndividualCreditors().subscribe(stream=>
  {
    this.dataSource.data=stream as any;
  });
    //  persons$.subscribe({
    //      next(person){ 
    //        console.log("personname",person); 
    //       },
    //      complete() { console.log(''); }
    //    });
    //    //const organizations$ =this.organizationService.findAllTopOrganizationCreditors();
    //    this.topPersons$ =persons$;
    //    this.dataSource=persons$;
       this.dataSource.sort=this.sort;
       this.dataSource.paginator=this.paginator;
    // this.personService.findAllTopIndividualCreditors().subscribe(
    //   list=>{
    //     let array=list.map(item=> {
    //       return{
    //         $key:item.key,
    //         ...item.payload.val()
    //       };
    //     });
    //     this.dataSource=new MatTableDataSource(array);
    //   });
}
   onSearchClear()
   {
     this.searchKey="";
   }
   applyFilter()
   {
     this.dataSource.filter=this.searchKey.trim().toLowerCase();
   }
}
