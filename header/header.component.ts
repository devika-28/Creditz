import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  title = 'Risk Management System';
  store = window.sessionStorage.getItem('userId');
  constructor() { }

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
} 