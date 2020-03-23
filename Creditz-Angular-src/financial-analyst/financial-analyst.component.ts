import {Component, OnInit} from '@angular/core';
import {Person} from "../model/person";
import {Organization} from "../model/Organization";
import {Observable} from "rxjs";
import {PersonService} from "../services/person.service";
import {OrganizationService} from "../services/organization.service";
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
@Component({
    selector: 'app-financial-analyst',
    templateUrl: './financial-analyst.component.html',
    styleUrls: ['./financial-analyst.component.css']
  })
export class FinancialAnalystComponent implements OnInit {

    topPersons$: Observable<any>;

    topOrganizations$: Observable<any>;

    constructor(private organizationService: OrganizationService,private personService:PersonService) {
   }

    ngOnInit() {
    
       const organization$ = this.organizationService.findAllTopOrganizationCreditors();
       const persons$ = this.personService.findAllTopIndividualCreditors();
       persons$.subscribe({
            next(personName){ console.log(personName); },
            complete() { console.log(''); }
          });
        console.log("this is"+persons$);
        this.topPersons$ =persons$;
        console.log("this is"+this.topPersons$);
        this.topOrganizations$ = organization$;

    }

}
