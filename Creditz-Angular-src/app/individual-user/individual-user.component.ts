import { Component, OnInit } from '@angular/core';
import { EMI } from '../model/emi';

@Component({
  selector: 'app-individual-user',
  templateUrl: './individual-user.component.html',
  styleUrls: ['./individual-user.component.css']
})
export class IndividualUserComponent implements OnInit {

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



  // calculateEMI: any = function(P: number , T:number){
  //   this.calculator.subscribe( (res: Response) =>{
  //     var interest = (P*T*11.5)/1200;
  //     window.alert((P+interest)/T  );
  //     return (P+interest)/T;
  //   }
  //   )}
}
