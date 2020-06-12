import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.css"],
})
export class HomeComponent implements OnInit {
  title = "Creditz";

  constructor() {
    document.body.style.backgroundImage = "url('assets/Home.jpg')";
    document.body.style.backgroundPosition = "center center";
    document.body.style.backgroundRepeat = "no-repeat";
    document.body.style.backgroundAttachment = "fixed";
    document.body.style.backgroundSize = "cover";
  }

  ngOnInit() {}
  ngOnDestroy() {
    document.body.style.backgroundImage = "none";
  }

  scroll(element) {
    window.scrollTo(element.yPosition);
  }
}
