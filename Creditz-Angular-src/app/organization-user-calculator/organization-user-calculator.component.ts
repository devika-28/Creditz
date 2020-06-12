import { Component, OnInit } from "@angular/core";
import { EMI } from "../model/emi";
import { ThrowStmt } from "@angular/compiler";

@Component({
  selector: "app-organization-user-calculator",
  templateUrl: "./organization-user-calculator.component.html",
  styleUrls: ["./organization-user-calculator.component.css"],
})
export class OrganizationUserCalculatorComponent implements OnInit {
  store = window.sessionStorage.getItem("userId");
  role = window.sessionStorage.getItem("role");
  calculatorModel = new EMI();
  constructor() {}

  ngOnInit() {}

  public greaterThan(subj: any, num: number) {
    return subj > num;
  }

  public lessThan(subj: any, num: number) {
    return subj < num;
  }

  checkusertype() {
    if (this.store != null && this.role == "Person") {
      window.alert(
        "Sorry!!! You are not eligible to view This Page\nLogin with an organizational credential to view this functionality."
      );
    } else {
      this.goToUrl("creditz/organization/apply");
    }
  }

  goToUrl(url: any) {
    window.open(url, "_self");
  }

  calculateEMI: any = function (principle: number, tenure: number) {
    var p: number = principle;
    var t: number = tenure;
    var interest = (p * 13.5 * t) / 1200;
    return Math.ceil((p + interest) / t);
  };
  maxTenure: any = function (principle: number) {
    if (principle < 235294) {
      var tenure = Math.floor(
        (1200 * principle) / (6000000 - principle * 13.5)
      );
      console.log(tenure);
      if (tenure > 0) {
        if (tenure <= 100) {
          return tenure;
        }
      } else return 100;
    } else return 100;
  };
}
