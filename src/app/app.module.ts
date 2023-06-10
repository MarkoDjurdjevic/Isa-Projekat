import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { CentreComponent } from './centre/centre.component';
import { CentreTermsComponent } from './centre-terms/centre-terms.component';
import { BloodFormularComponent } from './blood-formular/blood-formular.component';
import { CentreTermsRegUserComponent } from './centre-terms-reg-user/centre-terms-reg-user.component';
import { UpdateCentreComponent } from './update-centre/update-centre.component';
import { TermsCreateComponent } from './terms-create/terms-create.component';
import { BloodComponent } from './blood/blood.component';
import { TermsAdminComponent } from './terms-admin/terms-admin.component';
import { ReportComponent } from './report/report.component';
import { StatementComponent } from './statement/statement.component';
import { EquipmentAppointmentComponent } from './equipment-appointment/equipment-appointment.component';
import { RegistrationPageComponent } from './registration-page/registration-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { ListRegisterUserComponent } from './list-register-user/list-register-user.component';
import { AuthGuard } from './service/auth.guard';
import { GuestGuard } from './service/guest.guard';
import { RegisterUserComponent } from './register-user/register-user.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDialogModule } from '@angular/material/dialog';
import { AdminListComponent } from './admin-list/admin-list.component';
import { AvailabilityPageComponent } from './availability-page/availability-page.component';
import { RegisterUserPageComponent } from './register-user-page/register-user-page.component';
import { AllCentrePageComponent } from './all-centre-page/all-centre-page.component';
import { AdminProfileComponent } from './admin-profile/admin-profile.component';
import { AllTermsComponent } from './all-terms/all-terms.component';
import { AllUsersListComponent } from './all-users-list/all-users-list.component';
import { SystemAdminPageComponent } from './system-admin-page/system-admin-page.component';

const appRoutes: Routes = [
  {
    path: 'registration-page',
    component: RegistrationPageComponent,
    
  },
  { path: 'user-profile', component: UserProfileComponent },
  { path: 'centres', component: CentreComponent },
  { path: 'centres-terms', component: CentreTermsComponent },
  { path: 'blood-formular', component: BloodFormularComponent },
  { path: 'centres-terms-reg-user', component: CentreTermsRegUserComponent },
  { path: 'terms-create', component: TermsCreateComponent },
  { path: 'blood', component: BloodComponent },
  { path: 'terms-admin', component: TermsAdminComponent },
  { path: 'report', component: ReportComponent },
  { path: 'statement/:id',
   component: StatementComponent,
   canActivate: [AuthGuard],
   data: { allowedRoles: ['CENTRE_ADMINISTRATOR'] }
 },
  { path: 'equipment-appointment/:id', component: EquipmentAppointmentComponent,
    canActivate: [AuthGuard],
    data: { allowedRoles: ['CENTRE_ADMINISTRATOR'] }
 },
  { path: 'login-page', component: LoginPageComponent},
  { path: 'list-register-user', 
  component: ListRegisterUserComponent,
  canActivate: [AuthGuard],
  data: { allowedRoles: ['CENTRE_ADMINISTRATOR'] }},
  { path: 'register-user/:id', 
  component: RegisterUserComponent,
  canActivate: [AuthGuard],
  data: { allowedRoles: ['CENTRE_ADMINISTRATOR'] }},
  { path: 'admin-list', 
  component: AdminListComponent,
  canActivate: [AuthGuard],
  data: { allowedRoles: ['CENTRE_ADMINISTRATOR'] }},
  { path: 'availability-page/:id', component: AvailabilityPageComponent,
    canActivate: [AuthGuard],
    data: { allowedRoles: ['CENTRE_ADMINISTRATOR'] }
 },
 { path: 'register-user-page', component: RegisterUserPageComponent,
    canActivate: [AuthGuard],
    data: { allowedRoles: ['REGISTERED_USER'] }
 },
 { path: 'all-centre-page', component: AllCentrePageComponent},
 
 { path: 'admin-profile', component: AdminProfileComponent,
 canActivate: [AuthGuard],
 data: { allowedRoles: ['CENTRE_ADMINISTRATOR'] }
},
{ path: 'all-terms', component: AllTermsComponent,
canActivate: [AuthGuard],
data: { allowedRoles: ['CENTRE_ADMINISTRATOR'] }
},

{ path: 'all-users-list', component: AllUsersListComponent,
canActivate: [AuthGuard],
data: { allowedRoles: ['CENTRE_ADMINISTRATOR', 'SYSTEM_ADMINISTRATOR'] }
},

{ path: 'system-admin-page', component: SystemAdminPageComponent,
canActivate: [AuthGuard],
data: { allowedRoles: ['CENTRE_ADMINISTRATOR'] }
},
  
  
];
@NgModule({
  declarations: [
    AppComponent,
    UserProfileComponent,
    CentreComponent,
    CentreTermsComponent,
    BloodFormularComponent,
    CentreTermsRegUserComponent,
    TermsCreateComponent,
    BloodComponent,
    TermsAdminComponent,
    ReportComponent,
    StatementComponent,
    EquipmentAppointmentComponent,
    RegistrationPageComponent,
    LoginPageComponent,
    ListRegisterUserComponent,
    RegisterUserComponent,
    AdminListComponent,
    AvailabilityPageComponent,
    RegisterUserPageComponent,
    AllCentrePageComponent,
    AdminProfileComponent,
    AllTermsComponent,
    AllUsersListComponent,
    SystemAdminPageComponent,
    
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule,
    RouterModule.forRoot(appRoutes),
    BrowserAnimationsModule,
    MatDialogModule
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
