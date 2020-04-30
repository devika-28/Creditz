import { Component, OnInit } from '@angular/core';
import { ScheduleService } from '../services/schedule.service';

@Component({
  selector: 'app-schedular',
  templateUrl: './schedular.component.html',
  styleUrls: ['./schedular.component.css']
})
export class SchedularComponent implements OnInit {
  panelOpenState =false;
  store = window.sessionStorage.getItem('userId');
  storeRole = window.sessionStorage.getItem('role');
  constructor( private scheduleService:ScheduleService) { }

  ngOnInit(): void {
  }
personApplicantClick()
{
 this.scheduleService.scheduleEmailUpdatePersonApplicant().subscribe(data=>
  window.alert("Emails Sent!")

  );
}
organizationApplicantClick()
{
  this.scheduleService.scheduleEmailUOdateOrganizaionApplicant().subscribe(data=>
    window.alert("Emails Sent!")

    );
}




}
