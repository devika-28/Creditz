import { Component, OnInit, Input } from '@angular/core';
import { PersonApplicant } from '../model/personApplicant';

@Component({
  selector: 'app-person-application-list',
  templateUrl: './person-application-list.component.html',
  styleUrls: ['./person-application-list.component.css']
})
export class PersonApplicationListComponent implements OnInit {
  @Input() personapplicants: PersonApplicant[];
  constructor() { }
  ngOnInit(): void {
  }

}
