import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { FormGroup, FormBuilder } from '@angular/forms';
import { AnalystService } from '../services/analyst.service';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { AnalystDialogBoxComponent } from '../analyst-dialog-box/analyst-dialog-box.component';

@Component({
  selector: 'app-analyst-registration',
  templateUrl: './analyst-registration.component.html',
  styleUrls: ['./analyst-registration.component.css']
})
export class AnalystRegistrationComponent implements OnInit {
  store = window.sessionStorage.getItem('userId');
  storeRole = window.sessionStorage.getItem('role');
  userModel1=new User(1,'a@gmail.com','empty','default');
  registerForm: FormGroup;
  submitted = false;
  error: string;
  loading: false;
  constructor(private formBuilder: FormBuilder, private analystService:AnalystService,
    private router: Router,public dialog: MatDialog
    ) { }
  ngOnInit(){
    
  }
  
onSubmit1() {
  this.submitted = true;
  this.openDialog();
  console.log(this.userModel1);
  this.analystService.registerAnalyst(this.userModel1).subscribe(  
    data => {console.log('success'!,data)
    this.openDialog();
    this.router.navigate(['adminsidenav'], { queryParams: { registered: true }});
  },
  error => {
    
      this.error = error;
      this.loading = false;
      console.error('Error!',error)
      this.router.navigate(['analyst-registration'], { queryParams: { registered: true } });
  });
}
goToUrl(url: any){
window.open(url,"_self");
}

openDialog(): void {
  const dialogRef = this.dialog.open(AnalystDialogBoxComponent, {
    width: '400px',
    // data: {name: this.name, animal: this.animal}
  });

  dialogRef.afterClosed().subscribe(result => {
    console.log('The dialog was closed');
    // this.animal = result;
  });
}

}


