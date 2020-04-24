import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { MatStep} from '@angular/material/stepper'
import { OtpService } from '../services/otp.service';
import { User } from '../model/user';
import { UserService } from '../services/user.service';
import { AnalystService } from '../services/analyst.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {
  isLinear = true;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  userEmail:any
  otp:any;
  userModel1=new User(1,'a@gmail.com','empty','default');
  password: any;
  UserEmailCheck: any;
  constructor(private _formBuilder: FormBuilder, private otpService:OtpService,
    private userService:UserService,private analystService:AnalystService) {}

  ngOnInit() {
    this.firstFormGroup = this._formBuilder.group({
      userEmail: ['', Validators.required],
      otp: ['', Validators.required]
    });
    this.secondFormGroup = this._formBuilder.group({
      password: ['', [Validators.required,Validators.minLength(8)]],
      confirmpassword: ['', Validators.required]

    });
  }

sendOtp()
{
  window.alert("Wait some time otp is sending to your registered email address");
 this.otp= this.otpService.sendOtpToUser(this.firstFormGroup.controls['userEmail'].value).subscribe(  
      data => {console.log('success')
     this.otp=data;
     window.alert("otp has been sent to your registered email");
});

}
updateUser()
{
  this.userEmail =this.firstFormGroup.controls['userEmail'].value ;
  this. password =this.secondFormGroup.controls['password'].value;

  this.userService.updateUser(this.firstFormGroup.controls['userEmail'].value,
  this.secondFormGroup.controls['password'].value).subscribe(data=>
  {
    window.alert("Your password has been successfully changed");
    
  })
}


emailAlreadyExist="";
  emailCheckUnique()
   {
     this.analystService.checkUniqueEmail(this.firstFormGroup.controls['userEmail'].value).subscribe(res=>{
       this.UserEmailCheck=res;
       
         if(this.UserEmailCheck===null){
           
           this.emailAlreadyExist="Please entered a registered Email";
         }
           else
           {
            this.emailAlreadyExist="";
           }
         }
);
}

}
