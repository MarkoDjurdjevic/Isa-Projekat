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

const appRoutes: Routes = [
  { path: 'user-profile', component: UserProfileComponent },
  { path: 'centres', component: CentreComponent },
  { path: 'centres-terms', component: CentreTermsComponent },
];
@NgModule({
  declarations: [
    AppComponent,
    UserProfileComponent,
    CentreComponent,
    CentreTermsComponent,
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