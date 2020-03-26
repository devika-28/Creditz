import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminRoutingModule } from './admin-routing.module';
import { PersonService } from '../services/person.service';
import { OrganizationService } from '../services/organization.service';
import { AnalystService } from '../services/analyst.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTabsModule } from '@angular/material/tabs';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { AngularTiltModule } from 'angular-tilt';
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
import { BrowserModule } from '@angular/platform-browser';
import { AdminRegistrationComponent } from './admin-registration/admin-registration.component';
import { AdminsidebarComponent } from './adminsidebar/adminsidebar.component';
import { DefaultComponent } from './default/default.component';
import { ShowAnalystComponent } from './show-analyst/show-analyst.component';
//import { ConfirmEqualValidatorDirective } from '../shared/confirm-equal-validator.directive';

@NgModule({
  declarations: [AdminRegistrationComponent, AdminsidebarComponent, DefaultComponent, ShowAnalystComponent,],
  imports: [
    CommonModule,
    AdminRoutingModule,
    BrowserModule,
    // AppRoutingModule,
    
     CommonModule,
     BrowserAnimationsModule,
     MatTabsModule,
     FormsModule,
     ReactiveFormsModule,
     HttpClientModule,
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
     MatProgressSpinnerModule,
     //MatDrawer,
   // MatDrawerContainer,
     //MatDrawerContent,
    
  ],
  providers:[PersonService,OrganizationService,AnalystService],
  
})
export class AdminModule { }
