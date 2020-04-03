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
import { ConfirmEqualValidatorDirective } from './shared/confirm-equal-validator.directive';


import { MatPaginatorModule } from '@angular/material/paginator';
import { MatTableModule } from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSortModule } from '@angular/material/sort';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatListModule } from '@angular/material/list';
import { MatMenuModule } from '@angular/material/menu';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { CreditorTableListComponent } from './creditor-table-list/creditor-table-list.component';
import { AngularFireModule } from "@angular/fire";
import { AngularFireAuthModule } from "@angular/fire/auth";
import { AngularFirestoreModule } from '@angular/fire/firestore';
import { environment } from '../environments/environment';
// 1. Import the libs you need
import { AngularFireStorageModule } from '@angular/fire/storage';
import * as firebase from 'firebase';
import { OrganizationUserCalculatorComponent } from './organization-user-calculator/organization-user-calculator.component';
import { FooterComponent } from './footer/footer.component';
import { ShowAnalystComponent } from './show-analyst/show-analyst.component';
import { AdminsidenavComponent } from './adminsidenav/adminsidenav.component';
import { AnalystRegistrationComponent } from './analyst-registration/analyst-registration.component';
import { OrganizationCreditorTableListComponent } from './organization-creditor-table-list/organization-creditor-table-list.component';
import { ErrorComponent } from './error/error.component';
import { ApplicationSubmittionComponent } from './application-submittion/application-submittion.component';



export const route: Routes = [
  { path: " creditor-table-list",component:CreditorTableListComponent},
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
  { path: 'organization-user-calculator', component: OrganizationUserCalculatorComponent },
  { path: 'successful' , component: ApplicationSubmittionComponent },
  { path: '**', component:ErrorComponent}

];


const firebaseConfig = {
  apiKey: "AIzaSyBG0e2yCyr_rvPEVmLmJnXxa6szCYlk_kY",
  authDomain: "creditz-62be2.firebaseapp.com",
  databaseURL: "https://creditz-62be2.firebaseio.com",
  projectId: "creditz-62be2",
  storageBucket: "creditz-62be2.appspot.com",
  messagingSenderId: "616539689577",
  appId: "1:616539689577:web:1de336dd3a951d59dec8f8",
  measurementId: "G-L6MLJ255PG"
};
firebase.initializeApp(firebaseConfig);

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
    IndividualUserApplicationComponent,
    AboutUsComponent,
    FAQComponent,
    OurPoliciesComponent,
    ContactUsComponent,
    CreditorTableListComponent,
    ConfirmEqualValidatorDirective,
    OrganizationUserCalculatorComponent,
    FooterComponent,
    ShowAnalystComponent,
    AdminsidenavComponent,
    AnalystRegistrationComponent,
    OrganizationCreditorTableListComponent,
    ErrorComponent,
    ApplicationSubmittionComponent,
    
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
    MatTabsModule ,
    MatButtonModule,
    MatCardModule,
    AngularTiltModule,
    MatPaginatorModule,
    MatTableModule,
    MatInputModule,
    MatIconModule,
    MatSidenavModule ,
    MatToolbarModule,
    MatSortModule,
    MatFormFieldModule,
    FlexLayoutModule,
    MatListModule,
    MatMenuModule,
    HttpClientModule,
    MatProgressSpinnerModule,
    AngularFireModule.initializeApp(environment.firebase),
    AngularFireAuthModule,
    AngularFirestoreModule,
    AngularFireStorageModule,
    // MatPaginatorModule,
  ],
  providers: [PersonService,OrganizationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
