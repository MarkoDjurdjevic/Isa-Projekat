import { Component, OnInit } from '@angular/core';
import { RegisterUser } from '../model/registerUser';
import { RegisterUserservice } from '../service/register-user.service';
import { Router } from '@angular/router';
import { HttpHeaders } from '@angular/common/http';
import { AppointmentService } from '../service/appointment.service';
import { Centre } from '../model/centre';
import { NgFor } from '@angular/common';
import { NgForm } from '@angular/forms';
import { CentreService } from '../service/centre.service';
import { TermsService } from '../service/terms.service';
import { UserService } from '../service/user.service';
import { Terms } from '../model/terms';
import { LocationStrategy } from '@angular/common';


@Component({
  selector: 'app-register-user-page',
  templateUrl: './register-user-page.component.html',
  styleUrls: ['./register-user-page.component.css']
})
export class RegisterUserPageComponent implements OnInit {

  
  terms: Terms[] = [];
  term:Terms;
  showUpdateCentre:boolean= false;

  constructor(private registerUserService: RegisterUserservice,
    private termsService:TermsService,private locationStrategy: LocationStrategy) { }

  ngOnInit(): void {
    this.loadRegisteredUsers();
  }

  loadRegisteredUsers() {
    this.registerUserService.getAllTerms().subscribe(
      users => {
        this.terms = users;
      },
      error => {
        console.log('Error occurred while fetching registered users:', error);
      }
    );
  }

  rateCentre(){
    this.showUpdateCentre = true;
  }

  submitForm(form:NgForm){
    const registrationRequest = {
      rate: form.value.rate
    };

    this.registerUserService.rateForCenter(registrationRequest).subscribe(
      (response) => {
        console.log('User successfully registered');
        this.showUpdateCentre = false;
      },
      (error) => {
        console.log('Error registering user', error);
      }
    );

  }
  zakazivanjeTermina(id:number){
    console.log("nmp nesto")
    console.log(id);
    this.termsService.reserveTerms(id).subscribe(
      (response) => {
        console.log('User successfully registered');
        console.log(id);
        window.location.reload();

      },
      (error) => {
        console.log('Error registering user', error);
      }
    );
  }

}
