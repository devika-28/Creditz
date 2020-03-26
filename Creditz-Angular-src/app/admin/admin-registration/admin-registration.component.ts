import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AnalystService } from 'src/app/services/analyst.service';
import { User } from 'src/app/model/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-registration',
  templateUrl: './admin-registration.component.html',
  styleUrls: ['./admin-registration.component.css']
})
export class AdminRegistrationComponent implements OnInit {
  userModel1=new User(1,'a@gmail.com','empty','default');
  registerForm: FormGroup;
  submitted = false;
  error: string;
  loading: false;
  constructor(private formBuilder: FormBuilder, private analystService:AnalystService,
    private router: Router,
    ) { }
  ngOnInit(){
    
  }
  
onSubmit1() {
  this.submitted = true;
  console.log(this.userModel1);
  this.analystService.registerAnalyst(this.userModel1).subscribe(  
    data => {console.log('success'!,data)
    this.router.navigate(['default'], { queryParams: { registered: true }});
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

}


