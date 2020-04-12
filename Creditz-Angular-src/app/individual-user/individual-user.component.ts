import { Component, OnInit } from '@angular/core';
import { EMI } from '../model/emi';
import { MatDialog } from '@angular/material/dialog';
import { IndividualUserApplicationComponent } from '../individual-user-application/individual-user-application.component';

@Component({
  selector: 'app-individual-user',
  templateUrl: './individual-user.component.html',
  styleUrls: ['./individual-user.component.css']
})
export class IndividualUserComponent implements OnInit {

  calculatorModel = new EMI();
  constructor(public dialog: MatDialog) {}

  ngOnInit() {
    console.log( this.calculateEMI(1000,6))
  }

  goToUrl(url: any){
    window.open(url,'_self');
  }

   calculateEMI: any = function(principle:number, tenure:number){
      var p:number=principle;
      if(p> 150000){
        p=150000
      }
      var t:number=tenure;
      if(t>100){
        t=100
      }
    var interest = (p*11.5*t)/1200;
     return ((p+interest)/t);   
    
    }

    openDialog() {
      // const scrollStrategy = this.overlay.scrollStrategies.reposition();
      const dialogRef = this.dialog.open(IndividualUserApplicationComponent, {
        autoFocus: false,
        maxHeight: '90vh' //you can adjust the value as per your view
  
      });
    
    }



  // calculateEMI: any = function(P: number , T:number){
  //   this.calculator.subscribe( (res: Response) =>{
  //     var interest = (P*T*11.5)/1200;
  //     window.alert((P+interest)/T  );
  //     return (P+interest)/T;
  //   }
  //   )}
}
