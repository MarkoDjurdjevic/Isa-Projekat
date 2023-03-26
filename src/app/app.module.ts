import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { RouterModule, Routes } from '@angular/router';
import { CentreComponent } from './centre/centre.component';
import { CentreTermsComponent } from './centre-terms/centre-terms.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BloodFormularComponent } from './blood-formular/blood-formular.component';
import { UpdateCentreComponent } from './update-centre/update-centre.component';
import { TermsCreateComponent } from './terms-create/terms-create.component';

const appRoutes: Routes = [
  { path: 'user-profile', component: UserProfileComponent },
  { path: 'centres', component: CentreComponent },
  { path: 'centres-terms', component: CentreTermsComponent },
  { path: 'blood-formular', component: BloodFormularComponent },
  { path: 'update-centre', component: UpdateCentreComponent },
  { path: 'terms-create', component: TermsCreateComponent },
];
@NgModule({
  declarations: [
    AppComponent,
    UserProfileComponent,
    CentreComponent,
    CentreTermsComponent,
    BloodFormularComponent,
    UpdateCentreComponent,
    TermsCreateComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes),
    NgbModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
