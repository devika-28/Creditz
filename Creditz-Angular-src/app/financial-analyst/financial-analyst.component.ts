import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {PersonService} from "../services/person.service";
import {OrganizationService} from "../services/organization.service";
@Component({
    selector: 'app-financial-analyst',
    templateUrl: './financial-analyst.component.html',
    styleUrls: ['./financial-analyst.component.css']
  })
export class FinancialAnalystComponent implements OnInit {

  topPersons$: Observable<any>;
  topOrganizations:Observable<any>;
  displayedColumns: string[] = ['personId',  'personName',  'contact',  'address', '#'];
  displayedColumns1: string[] = ['organizationId'  , 'organizationName'  , 'contact'  , 'address'  , 'directorName'  ,'#'];
  dataSource:any;
  dataSource1:any;
  constructor(private personService: PersonService,private organizationService:OrganizationService) { }
  ngOnInit(){
    const persons$ =this.personService.findAllTopIndividualCreditors();
     persons$.subscribe({
         next(person){ 
           console.log("personname",person); 
          },
         complete() { console.log(''); }
       });
       const organizations$ =this.organizationService.findAllTopOrganizationCreditors();
       this.topPersons$ =persons$;
       this.dataSource=persons$;
       console.log("ppp"+this.dataSource);
       this.dataSource1=organizations$;
      
  }
}

  


   


