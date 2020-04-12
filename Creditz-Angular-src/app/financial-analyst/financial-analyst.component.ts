 import {Component, OnInit, Input} from '@angular/core';
 import {Observable} from "rxjs";
 import {PersonService} from "../services/person.service";
 import {OrganizationService} from "../services/organization.service";
import { OrganizationApplicant } from '../model/organizationapplicant';
import { trigger, state, style, transition, animate } from '@angular/animations';
import { PersonApplicant } from '../model/personApplicant';
import { ApplicationService } from '../services/application.service';
import { MatTableDataSource } from '@angular/material/table';
@Component({
  selector: 'app-financial-analyst',
    templateUrl: './financial-analyst.component.html',
    styleUrls: ['./financial-analyst.component.css'],
    animations: [
      trigger('detailExpand', [
        state('collapsed', style({height: '0px', minHeight: '0'})),
        state('expanded', style({height: '*'})),
        transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
      ]),
    ],
  })
export class FinancialAnalystComponent {
  dataSource=new MatTableDataSource<any[]>();
  dataSource1=new MatTableDataSource<any[]>();
  columnsToDisplay = ['personId','personName','contact','address'];
  columnsToDisplay1 = ['organizationId','organizationName','contact','address'];
  expandedElement: PersonApplicant| null;
  expandedElement1: OrganizationApplicant| null;
  constructor(private applicationService: ApplicationService) { }
   ngOnInit(){
   this.applicationService.findAllTopIndividualCreditors().subscribe(stream=>
    {
       this.dataSource.data=stream as any;
      // this.dataSource.paginator=this.paginator;
    });  
    this.applicationService.findAllTopOrganizationCreditors().subscribe(stream=>
      {
         this.dataSource1.data=stream as any;
        // this.dataSource.paginator=this.paginator;
      });   
  

   }

  }