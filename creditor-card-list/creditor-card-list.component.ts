import { Person } from './../model/person';
import { Component, OnInit, Input } from '@angular/core';
@Component({
  selector: 'app-creditor-card-list',
  templateUrl: './creditor-card-list.component.html',
  styleUrls: ['./creditor-card-list.component.css']
})
export class CreditorCardListComponent implements OnInit {
 @Input() persons: Person[];

 

  constructor(
 ) {
  }

  ngOnInit() {
  }


}
