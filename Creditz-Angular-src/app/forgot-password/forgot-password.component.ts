// import { Component, OnInit } from '@angular/core';
// import { User } from '../model/user';
// import { AngularFireAuth } from '@angular/fire/auth';
// import { AnalystService } from '../services/analyst.service';
// import { FormBuilder } from '@angular/forms';
// import { OtpService } from '../services/otp.service';
// import { Router } from '@angular/router';

// @Component({
//   selector: 'app-forget-password',
//   templateUrl: './forget-password.component.html',
//   styleUrls: ['./forget-password.component.css']
// })
// export class ForgetPasswordComponent implements OnInit {
//   UserEmailCheck: any;
//   userModel1=new User(1,'a@gmail.com','empty','default');
//   submitted: boolean;
//   error: any;
//   loading: boolean;

//   analystService: any;
//   constructor(
//     private otpService:OtpService,private router: Router
//   ) { }

//   ngOnInit(): void {
//   }

//   onSubmit() {
//     this.submitted = true;
//     console.log(this.userModel1);
//     this.otpService.sendOtpToUser(this.userModel1.userEmail).subscribe(  
//       data => {console.log('success'!,data)
//       this.router.navigate(['reset-password'],{ queryParams: {token:data }});
//     },
//     error => {
      
//         this.error = error;
//         this.loading = false;
//         console.error('Error!',error)
//         this.router.navigate(['analyst-registration'], { queryParams: { registered: true } });
//     });
//   }

  // emailAlreadyExist="";
  // emailCheckUnique()
  //  {
  //    this.analystService.checkUniqueEmail(this.userModel1.userEmail).subscribe(res=>{
  //      this.UserEmailCheck=res;
  //       console.log("done");
  //        if(this.UserEmailCheck===null){
  //          console.log("done");
  //          this.emailAlreadyExist="Please entered a registered Email";
  //        }
  //          else
  //          {
  //           this.emailAlreadyExist="";
  //          }
  //        }
       
       
  //    );
 
  //  }
  
//  }










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
  console.log(this.userEmail);
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
        console.log("done");
         if(this.UserEmailCheck===null){
           console.log("done");
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
