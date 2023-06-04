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

@Component({
  selector: 'app-list-register-user',
  templateUrl: './list-register-user.component.html',
  styleUrls: ['./list-register-user.component.css']
})
export class ListRegisterUserComponent implements OnInit {

  registeredUsers: RegisterUser[] = [];
  registerUser:RegisterUser;
  id:number;
  appointmentId: number;
  user:RegisterUser;
  showUpdateCentre: boolean = false;
  centre:Centre;
  showTermsForm: boolean = false;
  showUpdateUser:boolean = false;

  constructor(private registerUserService: RegisterUserservice,
    private appointmentService:AppointmentService,
    private router:Router,
    private centreService : CentreService,
    private termsService: TermsService,
    private userService: UserService
    ) { }

  ngOnInit() {
    this.loadRegisteredUsers();
  }

  loadRegisteredUsers() {
    this.registerUserService.registerUserByAppointment().subscribe(
      users => {
        this.registeredUsers = users;
      },
      error => {
        console.log('Error occurred while fetching registered users:', error);
      }
    );
  }

  goToAppointmentPage(id: number){

    this.router.navigate(['/register-user/',id]);
    console.log("ispisi nesto1")
  }

  public showAllAdministrator(){
    console.log("ispisi nestoooooooooo1")
    this.router.navigate(['/admin-list']);
 }

  public showUpdateCentreForm(){
    this.showUpdateCentre =true;
  }

    public showTermsFormm(){
    this.showTermsForm =true;
  }

  submitForm(form: NgForm) {
    const registrationRequest = {
      name: form.value.name,
      adress: form.value.adress,
      description: form.value.description,
      // avgGrade: form.value.avgGrade,
      // rate: form.value.rate 
    };

    this.centreService.updateCentre(registrationRequest).subscribe(
      (response) => {
        console.log('User successfully registered');
      },
      (error) => {
        console.log('Error registering user', error);
      }
    );
  }

  submitFormTerm(form: NgForm) {
    const registrationRequest = {
      duration: form.value.duration,
      date: form.value.date,
      time: form.value.time,
      // avgGrade: form.value.avgGrade,
      // rate: form.value.rate 
      systemAdminId: form.value.systemAdminId
    };

    this.termsService.addTerms(registrationRequest).subscribe(
      (response) => {
        console.log('User successfully registered');
      },
      (error) => {
        console.log('Error registering user', error);
      }
    );
  }

  showUpdateUserForm(){
    this.showUpdateUser = true;
  }

  submitFormUpdate(form: NgForm) {
    const registrationRequest = {
      email: form.value.email,
      name: form.value.name,
      lastname: form.value.lastname,
      password: form.value.password,
      username: form.value.username,
      //username: form.value.username,
      address: form.value.address,
      phoneNumber: form.value.phoneNumber,
      jmbg:form.value.jmbg,
      //password: form.value.password,
      roleName: form.value.roleName,
      genderName: form.value.genderName
     
    };

    this.userService.updateUser(registrationRequest).subscribe(
      (response) => {
        console.log('User successfully registered');
      },
      (error) => {
        console.log('Error registering user', error);
      }
    );
  }


  
  

}
