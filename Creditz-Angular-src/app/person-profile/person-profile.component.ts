import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { User } from '../model/user';
import { PersonService } from '../services/person.service';
import { Person } from '../model/person';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-person-profile',
  templateUrl: './person-profile.component.html',
  styleUrls: ['./person-profile.component.css']
})
export class PersonProfileComponent implements OnInit  {
  user:User;
  person:Person;
  userEmail="priyankadollJ@yahoo.com";
  constructor(private userService:UserService,private personService:PersonService,
    public dialog: MatDialog){ }
  ngOnInit(){


    this.userService.findUserByUserEmail(this.userEmail).subscribe(stream=>
      {
         this.user=stream as any;
         console.log(this.user);
         this.personService.findPersonByUserId(this.user.userId).
         subscribe(stream=>
      {
         this.person=stream as any;
         console.log(this.person);

      });

      });

    
     
   
  }
 
   
 
}
