import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { FormGroup, FormBuilder } from '@angular/forms';
import { AnalystService } from '../services/analyst.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-analyst-registration',
  templateUrl: './analyst-registration.component.html',
  styleUrls: ['./analyst-registration.component.css']
})
export class AnalystRegistrationComponent implements OnInit {

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
    this.router.navigate(['adminsidenav'], { queryParams: { registered: true }});
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


