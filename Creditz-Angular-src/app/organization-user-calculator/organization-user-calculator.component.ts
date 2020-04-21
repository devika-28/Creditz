import { Component, OnInit } from '@angular/core';
import { EMI } from '../model/emi';
import { ThrowStmt } from '@angular/compiler';

@Component({
  selector: 'app-organization-user-calculator',
  templateUrl: './organization-user-calculator.component.html',
  styleUrls: ['./organization-user-calculator.component.css']
})
export class OrganizationUserCalculatorComponent implements OnInit {


  store = window.sessionStorage.getItem('userId');
  role=window.sessionStorage.getItem('role');

  calculatorModel = new EMI();
  constructor() { }

  ngOnInit() {
    console.log( this.calculateEMI(1000,6))
  }
checkusertype(){
if(this.store!=null && this.role=='Person'){
  window.alert("sorry !!!you are not organization user ..");
}
  else{
    this.goToUrl('Orgnizational-user');
  }
}
  goToUrl(url: any){
    window.open(url,'_self');
  }

   calculateEMI: any = function(principle:number, tenure:number){
      var p:number=principle;
      var t:number=tenure;
    var interest = (p*13.5*t)/1200;
     return ((p+interest)/t);   
    
    }

}
