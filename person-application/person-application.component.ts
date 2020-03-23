
import { Component, OnInit,Input } from '@angular/core';
import { Observable } from 'rxjs';
import { PersonService } from '../services/person.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-person-application',
  templateUrl: './person-application.component.html',
  styleUrls: ['./person-application.component.css']
})
export class PersonApplicationComponent implements OnInit {

  applicationDetail$: Observable<any>;
  userId: Number;
  uid:Number;
  constructor(private personService:PersonService,private Activatedroute:ActivatedRoute,
  private router:Router){
}
 ngOnInit() {
    this.userId = +this.Activatedroute.queryParamMap
       .subscribe(params => {
     this.uid = +params.get('userId'); 
     console.log('Query params ',this.uid)     
});
 
    
      const applications$ = this.personService.findApplicationByAppliId(this.uid);
      applications$.subscribe({
        next(personName){ console.log(personName); },
        complete() { console.log(''); }
      });
      this.applicationDetail$ =applications$;
  }


}

