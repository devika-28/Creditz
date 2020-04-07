import { OrganizationService } from './../services/organization.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { User } from '../model/user';
import { Person } from '../model/person';
import { Organization } from '../model/organization';
import { RegistrationService } from '../services/registration.service';
import { NgIf } from '@angular/common';
import { AngularFireAuth } from '@angular/fire/auth';
//import { AngularFire, FirebaseListObservable } from 'angularfire';


import * as firebase from 'firebase';
import { stringToKeyValue } from '@angular/flex-layout/extended/typings/style/style-transforms';
//import { MustMatch } from '../shared/confirm-equal-validator.directive';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']

 
})
export class RegisterComponent implements OnInit {
 hasEmailverified=false;
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
  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private _registerService:RegistrationService,
    public afAuth:AngularFireAuth) {
      document.body.style.backgroundImage = "url('assets/img/images.jpg')";
      document.body.style.backgroundPosition = "center center";
      document.body.style.backgroundRepeat = "no-repeat";
      document.body.style.backgroundAttachment = "fixed";
      document.body.style.backgroundSize = "cover";

        firebase.auth().onAuthStateChanged(function(user){
          if(user){
         var user=firebase.auth().currentUser;
         if(user!=null){
           this.hasEmailverified=user.emailVerified;
           console.log(this.hasEmailverified);
          // window.alert("")
         }


          }





        });


  // this.afAuth.authState.subscribe(user=>{
  //       this.hasEmailverified=this.afAuth.auth.currentUser.emailVerified;


  //     });


    
     }

  ngOnInit() {
}
check:Boolean;
sendVerificationEmail(email,pass){
  console.log('verify email'); 
 this.check=true;
 var auth = firebase.auth();
 var user = firebase.auth().currentUser;

// create user and sign in
  var promise = auth.createUserWithEmailAndPassword(email, pass).catch(function(error){
    var errorCode=error.code;
    var errormsg=error.message;
    this.check=false;
    window.alert("Error :"+errormsg);
    this.check=false;
  });
  if(this.check){
 var result=user.sendEmailVerification().then(()=>{
    window.alert('check your mail to verify email otherwise you are unable to log in');
  }).catch(function(error){
    var errorCode=error.code;
    var errormsg=error.message;
    this.check=false;
     window.alert("Error :"+errormsg);
  });
  if(this.check){
    console.log('email verified');
   this.hasEmailverified=true;
  }
}
 
//  if(check==1){
//   this.hasEmailverified=false;
//  }
 // this.hasEmailverified=false;

}


onSubmit1() {

  this.submitted = true;
  console.log(this.personModel)
  console.log(this.userModel1)
   this.personModel.user=this.userModel1;
  this._registerService.registerPerson(this.personModel)
  .subscribe( 
    data => {console.log('success'!,data)
      this.router.navigate(['/login'], { queryParams: { registered: true }});
  },
  error => {
      this.error = error;
      this.loading = false;
      console.error('Error!',error)
  });
}


onSubmit2() {
  this.submitted = true;

  console.log(this.organizationModel)
  console.log(this.userModel2)
   this.organizationModel.user=this.userModel2;
  this._registerService.registerOrganization(this.organizationModel)
  .subscribe( 
    data => {console.log('success'!,data)
      this.router.navigate(['/login'], { queryParams: { registered: true }});
  },
  error => {
      this.error = error;
      this.loading = false;
      console.error('Error!',error)
  });
}


validateRole1(value){
 if(value=='default'){
   this.topicHasError1=true;
 }else{
   this.topicHasError1=false;
 }
}
 
validateRole2(value){
  if(value=='default'){
    this.topicHasError2=true;
  }else{
    this.topicHasError2=false;
  }
 }
   

goToUrl(url: any){
  window.open(url,"_self");
}
  
}