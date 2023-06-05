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

  centres: Centre[];
  centre:Centre;

  constructor(private authService: AuthService, private router: Router) {}

   ngOnInit(): void {
    this.loadCentre();
  }

  loadCentre(){
    this.authService.getCentres().subscribe(
      users => {
        this.centres = users;
      },
      error => {
        console.log('Error occurred while fetching registered users:', error);
      }
    );
  }

  isLoggedIn(): boolean {
    return this.authService.isUserLoggedIn();
  }

  logout(): void {
    this.authService.logout();
    this.router.navigate(['/login-page']);
  }
}
