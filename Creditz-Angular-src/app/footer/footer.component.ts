import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  constructor() { }

  openDialog(){
    window.alert("You have successfully subscribed to our mailing List!")
    window.location.reload()
  }
  ngOnInit(): void {
  }

}
