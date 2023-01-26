import { NgFor } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { NgbDate } from '@ng-bootstrap/ng-bootstrap';
import { UserRoleEnum } from '../enums/userRoleEnum';
import { Users } from '../model/user';
import { AuthService } from '../service/auth.service';
import { FormDataService } from '../service/Formdata.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css'],
})
export class UserProfileComponent implements OnInit {
  constructor(
    private userService: UserService,
    private authService: AuthService,
    private formService: FormDataService,
    private router: Router
  ) {}
  users: Users[];
  user: Users;
  loggedIn: boolean;
  loginAttempted = false;
  editMode = false;
  currentlyLoggedInUser: Users;
  showPopup = false;
  showPopupRegUser = false;
  appointmentTime: NgbDate;

  ngOnInit(): void {
    this.userService.getUsers().subscribe((users) => {
      this.users = users;
      console.log(this.users);
      this.loggedIn = this.authService.isLoggedIn;
      this.user = this.authService.loggedInUser;
    });
  }

  submitForm(form: NgForm) {
    this.loginAttempted = true;

    console.log(form);
    console.log(form.value);

    this.userService.login(form.value.email, form.value.password).subscribe(
      (user) => {
        if (user) {
          this.user = user;

          this.authService.login();
          this.loggedIn = this.authService.isLoggedIn;
          this.authService.currentlyLoggedInUser(user);
          console.log(`You have succesfully logged in!`);
        } else {
          console.log(
            `There is no user with corresponding email and password!`
          );
        }
      },
      (error) => {
        console.error(error);
        console.log(
          `An error occurred during the login process: ${error.message}`
        );
      }
    );
  }

  onEdit() {
    this.editMode = true;
  }
  updateUser(f) {
    console.log(f.value);
    const copy = Object.assign({}, f.value);
    console.log(copy);
    delete copy.id;
    console.log(f.value);
    console.log(copy);

    this.userService.updateUser(f.value.id, copy).subscribe(
      (response: Users) => {
        console.log(`Response from updateCentre:`, response);
      },
      (error) => {
        console.error(error);
      }
    );
    this.editMode = false;
  }

  //PopUp prozor
  onButtonClick() {
    this.showPopup = !this.showPopup;
  }

  onButtonClickRegUser() {
    this.showPopupRegUser = !this.showPopupRegUser;
  }

  ShowCentreAppointments(f) {
    console.log(f.value.appointmentTime);

    let dateString =
      this.appointmentTime.year +
      '-' +
      String(this.appointmentTime.month).padStart(2, '0') +
      '-' +
      String(this.appointmentTime.day).padStart(2, '0');

    console.log(dateString);
    f.value.appointmentTime = new Date(
      f.value.appointmentTime.year,
      f.value.appointmentTime.month - 1,
      f.value.appointmentTime.day
    );

    console.log(`Updated date: `, f.value.appointmentTime);

    //this.formService.updateDateAndTime(f.value.appointmentTime, f.value.time);
    //this.formService.updateDateAndTime(dateString, f.value.time); ovo sam sad izbacio
    this.formService.updateDateAndTimeAndDuration(
      dateString,
      f.value.time,
      f.value.duration
    );
    console.log(`DURATION: `, f.value.duration, `TIme:`, f.value.time);
    this.router.navigate(['/centres-terms']);
  }

  ShowCentreAppointmentsRegUser(f) {
    console.log(f.value.appointmentTime);

    let dateString =
      this.appointmentTime.year +
      '-' +
      String(this.appointmentTime.month).padStart(2, '0') +
      '-' +
      String(this.appointmentTime.day).padStart(2, '0');

    console.log(dateString);
    f.value.appointmentTime = new Date(
      f.value.appointmentTime.year,
      f.value.appointmentTime.month - 1,
      f.value.appointmentTime.day
    );

    console.log(`Updated date: `, f.value.appointmentTime);

    //this.formService.updateDateAndTime(f.value.appointmentTime, f.value.time);
    //this.formService.updateDateAndTime(dateString, f.value.time); ovo sam sad izbacio
    this.formService.updateDateAndTime(dateString, f.value.time);
    console.log(`DURATION: `, f.value.duration, `TIme:`, f.value.time);
    this.router.navigate(['/centres-terms-reg-user']);
  }

  CreateAppointment() {
    this.showPopup = !this.showPopup;
  }
}
