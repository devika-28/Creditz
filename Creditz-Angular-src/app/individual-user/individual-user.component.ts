import { Component, OnInit } from '@angular/core';
import { EMI } from '../model/emi';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { IndividualUserApplicationComponent } from '../individual-user-application/individual-user-application.component';

@Component({
  selector: 'app-individual-user',
  templateUrl: './individual-user.component.html',
  styleUrls: ['./individual-user.component.css']
})
export class IndividualUserComponent implements OnInit {
  store = window.sessionStorage.getItem('userId');
  role=window.sessionStorage.getItem('role');

  calculatorModel = new EMI();
  constructor(public dialog: MatDialog) {}

  ngOnInit() {
  }

  public greaterThan(subj: any, num: number) {
    return subj > num;
  }

  public lessThan(subj: any, num: number) {
    return subj < num;
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

    checkuser(){
          
      if(this.store!=null && this.role=='Organization')
      {
        window.alert("You are not authorized to see this page, If you are then please login with your organization credentials.");
      }
      else{
        this.goToUrl('creditz/individual/apply');
      }
    }


}
