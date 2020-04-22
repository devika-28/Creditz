import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { FormGroup, FormBuilder } from '@angular/forms';
import { AnalystService } from '../services/analyst.service';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { AnalystDialogBoxComponent } from '../analyst-dialog-box/analyst-dialog-box.component';
import { isNull } from 'util';
import { MailService } from '../services/mail.service';

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
  UserEmailCheck: any;
  constructor(private formBuilder: FormBuilder, private analystService:AnalystService,
    private mailService:MailService,
    private router: Router,public dialog: MatDialog
    ) { }
  ngOnInit(){
    
  }
  
  onSubmit1() {
    this.submitted = true;
    console.log(this.userModel1);
   
    this.analystService.registerAnalyst(this.userModel1).subscribe(  
    data => {console.log('success'!,data)
    this.mailService.sendMail(this.userModel1.userEmail,this.userModel1.password).subscribe
    (data=>console.log('success',data))
    this.openDialog();
    this.router.navigate(['adminsidenav'], {queryParams: { registered: true }});
    },
    error => {
        this.error = error;
        this.loading = false;
        console.error('Error!',error)
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

  emailAlreadyExist="";
 emailCheckUnique()
  {
    this.analystService.checkUniqueEmail(this.userModel1.userEmail).subscribe(res=>{
      this.UserEmailCheck=res;
       console.log("done");
        if(this.UserEmailCheck!==null){
          console.log("done");
          this.emailAlreadyExist="Email Already Exist";
        }
          else
          {
           this.emailAlreadyExist="";
          }
        }
      
      
    );

  }


}


