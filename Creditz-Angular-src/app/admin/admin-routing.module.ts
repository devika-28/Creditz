import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminRegistrationComponent } from './admin-registration/admin-registration.component';
import { RouterModule, Routes } from '@angular/router';
import { DefaultComponent } from './default/default.component';
import { AboutUsComponent } from '../about-us/about-us.component';
import { HomeComponent } from '../home/home.component';


export const adminRoutes: Routes = [
   { path:"admin-registration",component:AdminRegistrationComponent},
   { path:"default",component:DefaultComponent},
   { path:"aboutUs",component:AboutUsComponent},
   { path:'home', component: HomeComponent }
];

@NgModule({
  
  imports: [
    RouterModule.forChild(adminRoutes),
    CommonModule,
  ],
  exports:[RouterModule ]
})
export class AdminRoutingModule { }
