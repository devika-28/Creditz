import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { Person } from '../model/person';
import { Organization } from '../model/organization';
import { UserService } from '../services/user.service';
import { OrganizationService } from '../services/organization.service';

@Component({
  selector: 'app-organization-profile',
  templateUrl: './organization-profile.component.html',
  styleUrls: ['./organization-profile.component.css']
})
export class OrganizationProfileComponent implements OnInit {
    user:User;
    organization:Organization;
    userEmail="E&Y@co.in";
    constructor(private userService:UserService,private organizationService:OrganizationService){ }
    ngOnInit(){
  
  
      this.userService.findUserByUserEmail(this.userEmail).subscribe(stream=>
        {
           this.user=stream as any;
           console.log(this.user);
           this.organizationService.findOrganizationByUserId(this.user.userId).
           subscribe(stream=>
        {
           this.organization=stream as any;
           console.log(this.organization);
  
        });
  
        });
    
  }
 
}


