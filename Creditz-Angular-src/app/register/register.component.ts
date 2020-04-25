import { OrganizationService } from './../services/organization.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { User } from '../model/user';
import { Person } from '../model/person';
import { Organization } from '../model/organization';
import { RegistrationService } from '../services/registration.service';
import { NgIf } from '@angular/common';
import { stringToKeyValue } from '@angular/flex-layout/extended/typings/style/style-transforms';
import { ThrowStmt } from '@angular/compiler';
import { AnalystService } from '../services/analyst.service';
import { variable } from '@angular/compiler/src/output/output_ast';
import {MatDialog} from '@angular/material/dialog';
//const errorLog = require('../utils/log.js').errorlog;
//const successlog = require('../utils/log.js').successlog;

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {
  hasEmailverified=false;
  enterotp=false;
  emailid:string;
  roles1 = ['Person' ];
  roles2=['Organization'];
  registerForm: FormGroup;
  submitted = false;
  topicHasError1=true;
  topicHasError2=true;
  userModel1=new User(1,'a@gmail.com','empty','default');
  userModel2=new User(1,'a@gmail.com','empty','default');
  personModel=new Person(1,'shiv','678989238','sagar',this.userModel1);
  organizationModel=new Organization(1,'A','435665','bhopal','A.K.Rao',this.userModel2);
  error: string;
  loading: false;
  UserEmailCheck: any;
  otpno: any;
  store = window.sessionStorage.getItem('userId');
  storeRole = window.sessionStorage.getItem('role');
  constructor(
    public dialog: MatDialog,
    private analystService:AnalystService,
    private formBuilder: FormBuilder,
    private router: Router,
    private _registerService:RegistrationService) {}

  ngOnInit() {}

  emailAlreadyExist="";
  emailCheckUnique1(){
    this.analystService.checkUniqueEmail(this.userModel1.userEmail).subscribe(res=>{
    this.UserEmailCheck=res;
  //console.log("done");
  //successlog.info(`Success Message and variables: ${variable}`);
    if(this.UserEmailCheck!=null){
    //console.log("done");
      this.emailAlreadyExist="Email Already Exist";
    }
    else{
      this.emailAlreadyExist="";
    }
    });
  }

  emailCheckUnique2(){
    this.analystService.checkUniqueEmail(this.userModel2.userEmail).subscribe(res=>{
    this.UserEmailCheck=res;
    //console.log("done");
    if(this.UserEmailCheck!=null){
      console.log("done");
      this.emailAlreadyExist="Email Already Exist";
    }
    else{
      this.emailAlreadyExist="";
    }
    });
  }

  sendVerificationEmail(email){
   // console.log('verify email'); 
    //console.log(email); 
    window.alert("verifying Email Id \n please wait");
    this.emailid=email;
    this._registerService.sendotp(email).subscribe(data=>{
    this.otpno=data;
    console.log(data);
   // console.log("done");

    if(this.otpno!=null){
    window.alert("otp sent to your entered email\n Please check your email");
    this.enterotp=true;

    // const dialogRef = this.dialog.open(RegisterComponent,{
    //   height:"70%",
    //   width:"45%"
    // });
    }
    },
    error => {
      this.error = error;
      window.alert("error in sending otp \n Please check your entered  email \n enter correct email id");
      
    });
  }

  checkotp(otp){
    if(this.otpno==otp){
      this.hasEmailverified=true;
      this.enterotp=false;
    }
    else{
      window.alert("incorrect otp\nEnter correct otp");
    }
  }

  onSubmit1() {
    this.submitted = true;
    //console.log(this.personModel)
   //console.log(this.userModel1)
    this.personModel.user=this.userModel1;
    this._registerService.registerPerson(this.personModel)
    .subscribe( 
      data => {
        window.alert("you have registered successfully!!!")
       //console.log('success'!,data)
        this.router.navigate(['/login'], { queryParams: { registered: true }});
      },
      error => {
        this.error = error;
        this.loading = false;
        //console.error('Error!',error)
        //errorLog.error(`Error Message : ${error}`);
      }
    );
  }

  onSubmit2() {
    this.submitted = true;
    //console.log(this.organizationModel)
   // console.log(this.userModel2)
    this.organizationModel.user=this.userModel2;
    this._registerService.registerOrganization(this.organizationModel)
    .subscribe( 
    data => { 
      window.alert("you have registered successfully!!!");
      //console.log('success'!,data)
      this.router.navigate(['/login'], { queryParams: { registered: true }});
    },
    error => {
      this.error = error;
      this.loading = false;
      //console.error('Error!',error)
     // errorLog.error(`Error Message : ${error}`);
    });
  }

  validateRole1(value){
    if(value=='default'){
      this.topicHasError1=true;
    }
    else{
      this.topicHasError1=false;
    }
  }
 
  validateRole2(value){
    if(value=='default'){
      this.topicHasError2=true;
    }
    else{
      this.topicHasError2=false;
    }
  }

  goToUrl(url: any){
    window.open(url,"_self");
  }
}  