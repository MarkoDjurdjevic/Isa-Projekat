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

const appRoutes: Routes = [
  { path: 'user-profile', component: UserProfileComponent },
  { path: 'centres', component: CentreComponent },
  { path: 'centres-terms', component: CentreTermsComponent },
  { path: 'blood-formular', component: BloodFormularComponent },
  { path: 'centres-terms-reg-user', component: CentreTermsRegUserComponent },
  { path: 'terms-create', component: TermsCreateComponent },
  { path: 'blood', component: BloodComponent },
  { path: 'terms-admin', component: TermsAdminComponent },
  { path: 'report', component: ReportComponent },
  { path: 'statement', component: StatementComponent },
  { path: 'equipment-appointment', component: EquipmentAppointmentComponent },
  
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
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule,
    RouterModule.forRoot(appRoutes),
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
