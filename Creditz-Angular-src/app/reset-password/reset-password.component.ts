import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { AnalystService } from '../services/analyst.service';
import { UserService } from '../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent implements OnInit {

  store = window.sessionStorage.getItem('userId');
  storeRole = window.sessionStorage.getItem('role');
  userModel1=new User(1,'a@gmail.com','empty','default');
  userModel2=new User(1,'a@gmail.com','empty','default');
  UserEmailCheck: any;
  constructor(private analystService:AnalystService,private userService: UserService,
               private router:Router) { }

  ngOnInit(): void {
  }

  emailAlreadyExist="";
 emailCheckUnique()
  {
    this.analystService.checkUniqueEmail(this.userModel1.userEmail).subscribe(res=>{
      this.UserEmailCheck=res;
        if(this.UserEmailCheck===null){
          this.emailAlreadyExist="Please enter a  Registered email";
        }
          else
          {
           this.emailAlreadyExist="";
          }
        }
      
      
    );
}
 onSubmitForm() {
    this.userService.findUserByEmailAndPassword(this.userModel1.userEmail,this.userModel2.password).subscribe(  
    data => {
      if(data.userEmail===null)
      {
        window.alert("Your Email or Password is incorrect, Please enter a valid Email and Password!");
      }
      else
      {
        this.userService.updateUser(this.userModel1.userEmail,this.userModel1.password).
        subscribe(data=>
          {
            window.alert("Your password is changed, Successfully!");
            this.router.navigate(['login']);
          })
      }
    }
    );
      
   
  }

 
  }