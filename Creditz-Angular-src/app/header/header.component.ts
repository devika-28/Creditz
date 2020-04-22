import { Component, OnInit } from '@angular/core';
import { HistoryComponent } from '../history/history.component';
import {MatDialog} from '@angular/material/dialog';
import { HomeComponent } from '../home/home.component';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  title = 'Risk Management System';
  store = window.sessionStorage.getItem('userId');
  constructor(public dialog: MatDialog) {}

  ngOnInit(): void {
  }

  goToUrl(url: string){
    window.open(url,"_self");
}
logout(){
  window.sessionStorage.removeItem('userId');
  window.sessionStorage.removeItem('role');
  window.alert("You have been logged Out");
  window.location.reload()
}

openProfileDialog() {
  const dialogRef = this.dialog.open(HomeComponent);
}

openDialog() {
  const dialogRef = this.dialog.open(HistoryComponent);
}
} 