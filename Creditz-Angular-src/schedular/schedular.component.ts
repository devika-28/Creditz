import { Component, OnInit } from '@angular/core';
import { ScheduleService } from '../services/schedule.service';

@Component({
  selector: 'app-schedular',
  templateUrl: './schedular.component.html',
  styleUrls: ['./schedular.component.css']
})
export class SchedularComponent implements OnInit {
  panelOpenState =false;
  constructor( private scheduleService:ScheduleService) { }

  ngOnInit(): void {
  }
personApplicantClick()
{
 this.scheduleService.scheduleEmailUpdatePersonApplicant().subscribe(data=>
  console.log("done")
  );
}
organizationApplicantClick()
{
  this.scheduleService.scheduleEmailUOdateOrganizaionApplicant().subscribe(data=>
    console.log("done")
    );
}




}
