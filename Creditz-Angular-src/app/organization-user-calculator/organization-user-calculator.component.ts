import { Component, OnInit } from '@angular/core';
import { EMI } from '../model/emi';

@Component({
  selector: 'app-organization-user-calculator',
  templateUrl: './organization-user-calculator.component.html',
  styleUrls: ['./organization-user-calculator.component.css']
})
export class OrganizationUserCalculatorComponent implements OnInit {

  calculatorModel = new EMI();
  constructor() { }

  ngOnInit() {
    console.log( this.calculateEMI(1000,6))
  }

  goToUrl(url: any){
    window.open(url,'_self');
  }

   calculateEMI: any = function(principle:number, tenure:number){
      var p:number=principle;
      var t:number=tenure;
    var interest = (p*11.5*t)/1200;
     return ((p+interest)/t);   
    
    }

}
