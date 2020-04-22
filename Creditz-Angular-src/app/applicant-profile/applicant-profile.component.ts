import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { PersonService } from '../services/person.service';
import { Person } from '../model/person';
import { Organization } from '../model/organization';
import { OrganizationService } from '../services/organization.service';

@Component({
  selector: 'app-applicant-profile',
  templateUrl: './applicant-profile.component.html',
  styleUrls: ['./applicant-profile.component.css']
})
export class ApplicantProfileComponent implements OnInit {

  person:Person;
  organization:Organization;
 // userEmail="priyankadollJ@yahoo.com";
  store = window.sessionStorage.getItem('userId');
  storeRole = window.sessionStorage.getItem('role');
  constructor(private userService:UserService,private personService:PersonService,
    private organizationService:OrganizationService
){ }
  ngOnInit(){
        if(this.storeRole="person")
         {
         this.personService.findPersonByUserId(this.store).
         subscribe(stream=>
         {
         this.person=stream as any;
         console.log(this.person);

      });
 }
    else{
      this.organizationService.findOrganizationByUserId(this.store).
      subscribe(stream=>
   {
      this.organization=stream as any;
      console.log(this.organization);

   });

  
    }

    
     
   
  }
 
   
 
}