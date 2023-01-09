import { NgFor } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Users } from '../model/user';
import { AuthService } from '../service/auth.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css'],
})
export class UserProfileComponent implements OnInit {
  constructor(
    private userService: UserService,
    private authService: AuthService
  ) {}
  users: Users[];
  user: Users;
  loggedIn: boolean;
  loginAttempted = false;
  editMode = false;
  currentlyLoggedInUser: Users;

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
}
