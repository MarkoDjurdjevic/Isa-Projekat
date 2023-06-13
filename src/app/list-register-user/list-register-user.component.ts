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
import { CentreAdmin } from '../model/centreAdmin';

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
  name: string;
  lastname: string;
  searchName: string = ''; // Svojstvo za čuvanje vrednosti unetog imena
  filteredUsers: any[] = []; // Niz za filtrirane korisnike
  foundUser: any;
  centreAdmin:CentreAdmin

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
        this.sortUsersByName();
        this.sortUsersByLastName()
      },
      error => {
        console.log('Error occurred while fetching registered users:', error);
      }
    );
  }

  sortUsersByName() {
    this.registeredUsers.sort((a, b) => {
      const nameA = a.name.toLowerCase();
      const nameB = b.name.toLowerCase();
      if (nameA < nameB) {
        return -1;
      }
      if (nameA > nameB) {
        return 1;
      }
      return 0;
    });
  }

  sortUsersByLastName() {
    this.registeredUsers.sort((a, b) => {
      const lastNameA = a.lastname.toLowerCase();
      const lastNameB = b.lastname.toLowerCase();
      if (lastNameA < lastNameB) {
        return -1;
      }
      if (lastNameA > lastNameB) {
        return 1;
      }
      return 0;
    });
  }

  showProfileOfUser(){
    this.centreService.getCentreAdmin().subscribe(
      users => {
        this.centreAdmin = users;
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
      address: form.value.address,
      description: form.value.description,
      // avgGrade: form.value.avgGrade,
      // rate: form.value.rate 
    };

    this.centreService.updateCentre(registrationRequest).subscribe(
      (response) => {
        console.log('User successfully registered');
        this.showUpdateCentre = false;
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
        this.showTermsForm = false;
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
      // email: form.value.email,
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
        this.showUpdateUser = false;
      },
      (error) => {
        console.log('Error registering user', error);
      }
    );
  }

  searchUser() {
    this.centreService.searchUser(this.name, this.lastname).subscribe(
      (response) => {
        console.log('Centre search successful');
        this.foundUser = response; 
      },
      (error) => {
        console.log('Error searching centre', error);
      }
    );
  }
  
    applyFilter() {
    this.filteredUsers = this.registeredUsers.filter(user =>
      user.name.toLowerCase().includes(this.searchName.toLowerCase())
    );
  }

  close(){
    this.showTermsForm = false;
  }



  
  

}
