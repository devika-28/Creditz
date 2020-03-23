import { Login } from './model/login';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';
import { Routes, RouterModule } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { NgForm } from '@angular/forms';
// import {HttpModule} from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import { AdminComponent } from './admin/admin.component';
import { IndividualUserComponent } from './individual-user/individual-user.component';
import { OrganizationalUserComponent } from './organizational-user/organizational-user.component';
import { FinancialAnalystComponent } from './financial-analyst/financial-analyst.component';
import { OrganizationApplicationComponent } from './organization-application/organization-application.component';
import { OrganizationApplicationListComponent } from './organization-application-list/organization-application-list.component';
import { PersonApplicationComponent } from './person-application/person-application.component';
import { PersonApplicationListComponent } from './person-application-list/person-application-list.component';
import { CreditorCardListComponent } from './creditor-card-list/creditor-card-list.component';
import { Creditor1CardListComponent } from './creditor1-card-list/creditor1-card-list.component';
// import { AuthenticateComponent } from './authenticate/authenticate.component';
// import {MatTableModule} from '@angular/material/table';
import {MatTabsModule} from '@angular/material/tabs';
import {MatButtonModule} from '@angular/material/button';
// import {MatPaginatorModule } from '@angular/material/paginator';
import { PersonService } from './services/person.service';
import { OrganizationService } from './services/organization.service';
import { MatCardModule } from '@angular/material/card';
// import { HomePageComponent } from './home-page/home-page.component';
import { AngularTiltModule } from 'angular-tilt';
import {EMI} from '../app/model/emi';
import { IndividualUserApplicationComponent } from './individual-user-application/individual-user-application.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { FAQComponent } from './faq/faq.component';
import { OurPoliciesComponent } from './our-policies/our-policies.component';
import { ContactUsComponent } from './contact-us/contact-us.component';




export const route: Routes = [
  { path: '', component: HomeComponent },
  { path: '#', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'home', component: HomeComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'admin', component: AdminComponent },
  { path: 'financial-analyst', component: FinancialAnalystComponent },
  { path: 'individual-user', component: IndividualUserComponent },
  { path: 'individual-user/individual-user-application', component: IndividualUserApplicationComponent },
  { path: 'Orgnizational-user', component: OrganizationalUserComponent },
  {path: "financial-analyst/person-application", component: PersonApplicationComponent },
  {path: "financial-analyst/organization-application", component: OrganizationApplicationComponent },
  { path: 'contactUs', component: ContactUsComponent },
  { path: 'ourPolicies', component: OurPoliciesComponent },
  { path: 'faq', component: FAQComponent },
  { path: 'aboutUs', component: AboutUsComponent },


];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    HomeComponent,
    RegisterComponent,
    AdminComponent,
    IndividualUserComponent,
    OrganizationalUserComponent,
    FinancialAnalystComponent,
    OrganizationApplicationComponent,
    OrganizationApplicationListComponent,
    PersonApplicationComponent,
    PersonApplicationListComponent,
    CreditorCardListComponent,
    Creditor1CardListComponent,
    IndividualUserApplicationComponent,
    AboutUsComponent,
    FAQComponent,
    OurPoliciesComponent,
    ContactUsComponent,
    
    // AuthenticateComponent,
    // HttpClientModule,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(route),
    BrowserAnimationsModule,
    MatTabsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatTabsModule ,
    MatButtonModule,
    MatCardModule,
    AngularTiltModule,
    // MatTableModule,
    // MatPaginatorModule,
  ],
  providers: [PersonService,OrganizationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
