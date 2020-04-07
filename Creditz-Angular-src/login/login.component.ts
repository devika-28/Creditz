import { FormBuilder, FormGroup, Validators } from  '@angular/forms';
import { Router } from  '@angular/router';
import { Login } from  '../model/login';
import { User } from 'src/app/model/user';
import { LoginService } from  'src/app/services/login.service';
import { Component, NgModule, OnInit } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

// @NgModule({    
// imports: [
//   FormGroup,
//   LoginService,
//   ReactiveFormsModule,
// ],
// })
  
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['../individual-user/individual-user.component.css'],
})
export class LoginComponent implements OnInit {

  store = window.sessionStorage.getItem('userId');
  storeRole = window.sessionStorage.getItem('role');

  
  loginModel = new Login(null,null);
  // loginModel = new Login("","");

 constructor(  private loginService: LoginService  )  {}

 ngOnInit() { }
 
 onSubmit() {
       console.log(this.loginModel.password);
       console.log(typeof(this.loginModel.userEmail));
       console.log("submitted");
       this.loginService.login(this.loginModel.userEmail ,this.loginModel.password);
       
 }  

 goToUrl(url: any){
   window.open(url,"_self");
 }

}