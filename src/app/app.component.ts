 import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
 import { AuthService } from './service/auth.service';
 import { Router } from '@angular/router';

import {
  HttpClient,
  HttpClientModule,
  HttpErrorResponse,
} from '@angular/common/http';
import { AppService } from './app.service';
import { CentreService } from './service/centre.service';
import { Centre } from './model/centre';
import { Subscription } from 'rxjs';
import { FormBuilder, FormGroup, NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})

export class AppComponent {
  constructor(private authService: AuthService, private router: Router) {}

  isLoggedIn(): boolean {
    return this.authService.isUserLoggedIn();
  }

  logout(): void {
    this.authService.logout();
    this.router.navigate(['/login-email']);
  }
}
