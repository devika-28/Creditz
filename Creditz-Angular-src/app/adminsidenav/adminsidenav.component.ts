import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-adminsidenav',
  templateUrl: './adminsidenav.component.html',
  styleUrls: ['./adminsidenav.component.css']
})
export class AdminsidenavComponent implements OnInit {
  store = window.sessionStorage.getItem('userId');
  storeRole = window.sessionStorage.getItem('role');
  constructor() { }

  ngOnInit(): void {
  }

}
