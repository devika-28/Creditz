import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { OrganizationService } from '../services/organization.service';

@Component({
  selector: 'app-organization-application',
  templateUrl: './organization-application.component.html',
  styleUrls: ['./organization-application.component.css']
})
export class OrganizationApplicationComponent implements OnInit {

 
  applicationDetail$: Observable<any>;
  organizationId: Number;
  uid:Number;
  constructor(private organizationService:OrganizationService,private Activatedroute:ActivatedRoute,
  private router:Router){
}
 ngOnInit() {
    this.organizationId = +this.Activatedroute.queryParamMap
       .subscribe(params => {
        this.uid = +params.get('userId'); 
        console.log('Query params ',this.uid)     
});
      const applications$ = this.organizationService.findApplicationByAppliId(this.uid);
      applications$.subscribe({
        next(organizationName){ console.log(organizationName); },
        complete() { console.log(''); }
      });
      this.applicationDetail$ =applications$;
  }


}



