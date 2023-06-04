import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-registration-page',
  templateUrl: './registration-page.component.html',
  styleUrls: ['./registration-page.component.css']
})
export class RegistrationPageComponent implements OnInit {

  constructor(private authSevice: AuthService) {}

  email: string = '';
  password: string = '';
  // address: string = '';
  // JMBG: string = '';
  // username: string = '';
  JMBGbr: string = '';

  ngOnInit(): void {}

  submitForm(form: NgForm) {
      const registrationRequest = {
        email: this.email,
        name: form.value.name,
        lastname: form.value.lastname,
        password: this.password,
        username: form.value.username,
        //username: form.value.username,
        address: form.value.address,
        phoneNumber: form.value.phoneNumber,
        jmbg:form.value.jmbg,
        //password: form.value.password,
        roleName: form.value.roleName,
        genderName: form.value.genderName
       
      };

      this.authSevice.signup(registrationRequest).subscribe(
        (response) => {
          console.log('User successfully registered');
        },
        (error) => {
          console.log('Error registering user', error);
        }
      );
    }
  
}
