import { Component, OnInit, Input } from '@angular/core';
import { Organization } from '../Model/organization';

@Component({
  selector: 'app-creditor1-card-list',
  templateUrl: './creditor1-card-list.component.html',
  styleUrls: ['./creditor1-card-list.component.css']
})
export class Creditor1CardListComponent implements OnInit {

  @Input() organizations: Organization[];

  constructor() {
  }

  ngOnInit() {
  }


}
