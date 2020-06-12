import { Login } from "./model/login";
import { BrowserModule } from "@angular/platform-browser";
import { NgModule, Component, OnDestroy } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { LoginComponent } from "./login/login.component";
import { HeaderComponent } from "./header/header.component";
import { Routes, RouterModule } from "@angular/router";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { HomeComponent } from "./home/home.component";
import { RegisterComponent } from "./register/register.component";
import { NgForm } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { IndividualUserComponent } from "./individual-user/individual-user.component";
import { OrganizationalUserComponent } from "./organizational-user/organizational-user.component";
import { FinancialAnalystComponent } from "./financial-analyst/financial-analyst.component";
import { MatTabsModule } from "@angular/material/tabs";
import { MatButtonModule } from "@angular/material/button";
import { PersonService } from "./services/person.service";
import { OrganizationService } from "./services/organization.service";
import { MatCardModule } from "@angular/material/card";
import { AngularTiltModule } from "angular-tilt";
import { EMI } from "../app/model/emi";
import { IndividualUserApplicationComponent } from "./individual-user-application/individual-user-application.component";
import { AboutUsComponent } from "./about-us/about-us.component";
import { ContactUsComponent } from "./contact-us/contact-us.component";
import { ConfirmEqualValidatorDirective } from "./shared/confirm-equal-validator.directive";

import { MatPaginatorModule } from "@angular/material/paginator";
import { MatTableModule } from "@angular/material/table";
import { MatInputModule } from "@angular/material/input";
import { MatIconModule } from "@angular/material/icon";
import { MatSidenavModule } from "@angular/material/sidenav";
import { MatToolbarModule } from "@angular/material/toolbar";
import { MatSortModule } from "@angular/material/sort";
import { MatFormFieldModule } from "@angular/material/form-field";
import { FlexLayoutModule } from "@angular/flex-layout";
import { MatListModule } from "@angular/material/list";
import { MatMenuModule } from "@angular/material/menu";
import { MatProgressSpinnerModule } from "@angular/material/progress-spinner";
import { CreditorTableListComponent } from "./creditor-table-list/creditor-table-list.component";
import { AngularFireModule } from "@angular/fire";
import { AngularFireAuthModule } from "@angular/fire/auth";
import { AngularFirestoreModule } from "@angular/fire/firestore";
import { environment } from "../environments/environment";
import { AngularFireStorageModule } from "@angular/fire/storage";
import * as firebase from "firebase";
import { OrganizationUserCalculatorComponent } from "./organization-user-calculator/organization-user-calculator.component";
import { FooterComponent } from "./footer/footer.component";
import { ShowAnalystComponent } from "./show-analyst/show-analyst.component";
import { AdminsidenavComponent } from "./adminsidenav/adminsidenav.component";
import { AnalystRegistrationComponent } from "./analyst-registration/analyst-registration.component";
import { OrganizationCreditorTableListComponent } from "./organization-creditor-table-list/organization-creditor-table-list.component";
import { ErrorComponent } from "./error/error.component";
import { ApplicationSubmittionComponent } from "./application-submittion/application-submittion.component";
import { SchedularComponent } from "./schedular/schedular.component";
import { MatExpansionModule } from "@angular/material/expansion";
import { AnalystDialogBoxComponent } from "./analyst-dialog-box/analyst-dialog-box.component";
import { MatDialogModule } from "@angular/material/dialog";
import { MatTooltipModule } from "@angular/material/tooltip";
import { HistoryComponent } from "./history/history.component";
import { ShowHidePasswordModule } from "ngx-show-hide-password";
import { ForgotPasswordComponent } from "./forgot-password/forgot-password.component";
import { ResetPasswordComponent } from "./reset-password/reset-password.component";
import { MatStepperModule } from "@angular/material/stepper";
import { ApplicantProfileComponent } from "./applicant-profile/applicant-profile.component";
import { MatSelectModule } from "@angular/material/select";

export const route: Routes = [
  { path: " creditor-table-list", component: CreditorTableListComponent },
  { path: "", component: HomeComponent },
  { path: "#", component: HomeComponent },
  { path: "login", component: LoginComponent },
  { path: "creditz/home", component: HomeComponent },
  { path: "register", component: RegisterComponent },
  { path: "financial-analyst", component: FinancialAnalystComponent },
  { path: "creditz/individual", component: IndividualUserComponent },
  {
    path: "creditz/individual/apply",
    component: IndividualUserApplicationComponent,
  },
  {
    path: "creditz/organization/apply",
    component: OrganizationalUserComponent,
  },
  { path: "creditz/contactUs", component: ContactUsComponent },
  { path: "creditz/aboutUs", component: AboutUsComponent },
  {
    path: "creditz/organization",
    component: OrganizationUserCalculatorComponent,
  },
  { path: "successful", component: ApplicationSubmittionComponent },
  { path: "show-analyst", component: ShowAnalystComponent },
  { path: "schedular", component: SchedularComponent },
  { path: "creditz/aboutUs", component: AboutUsComponent },
  { path: "creditor-table-list", component: CreditorTableListComponent },
  {
    path: "organization-creditor-list",
    component: OrganizationCreditorTableListComponent,
  },
  { path: "admin", component: AdminsidenavComponent },
  { path: "analyst-registration", component: AnalystRegistrationComponent },
  { path: "show-analyst", component: ShowAnalystComponent },
  { path: "schedular", component: SchedularComponent },
  { path: "creditz/history", component: HistoryComponent },
  { path: "forgot-password", component: ForgotPasswordComponent },
  { path: "reset-password", component: ResetPasswordComponent },
  { path: "applicant-profile", component: ApplicantProfileComponent },
  { path: "**", component: ErrorComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    HomeComponent,
    RegisterComponent,
    IndividualUserComponent,
    OrganizationalUserComponent,
    FinancialAnalystComponent,
    IndividualUserApplicationComponent,
    AboutUsComponent,
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
    SchedularComponent,
    AnalystDialogBoxComponent,
    HistoryComponent,
    ForgotPasswordComponent,
    ResetPasswordComponent,
    ApplicantProfileComponent,

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
    MatTabsModule,
    MatButtonModule,
    MatCardModule,
    AngularTiltModule,
    MatPaginatorModule,
    MatTableModule,
    MatInputModule,
    MatIconModule,
    MatSidenavModule,
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
    MatExpansionModule,
    MatDialogModule,
    MatTooltipModule,
    ShowHidePasswordModule,
    MatStepperModule,
    MatSelectModule,
  ],
  providers: [PersonService, OrganizationService],
  bootstrap: [AppComponent],
})
export class AppModule {}
