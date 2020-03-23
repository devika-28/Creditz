import { Component, OnInit, Input } from '@angular/core';
import { OrganizationApplicant } from '../model/organizationapplicant';

@Component({
  selector: 'app-organization-application-list',
  templateUrl: './organization-application-list.component.html',
  styleUrls: ['./organization-application-list.component.css']
})
export class OrganizationApplicationListComponent implements OnInit {
  @Input() organizationapplicants: OrganizationApplicant[];
  constructor() { }

  ngOnInit(): void {
  }

}
