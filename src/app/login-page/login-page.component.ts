import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from '../service/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  email: string = '';
  password: string = '';
  
  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit(): void {}

  submitForm(form: NgForm) {
    const email = form.value.email;
    const password = form.value.password;

    this.authService.login(email,password).subscribe(
      (response) => {
        const role = this.authService.getRole();
        if (role === 'CENTRE_ADMINISTRATOR') {
          this.router.navigate(['/list-register-user']);
        }if(role === 'REGISTERED_USER')
        {
          this.router.navigate(['/register-user-page']);
        }
        if(role === 'SYSTEM_ADMINISTRATOR')
        {
          this.router.navigate(['/all-users-list']);
        }
        console.log('You have successfuly logged in!');
      },
      (error) => {
        console.log('Login failed:', error);
        // Show error message to user
      }
    );
  }

}
