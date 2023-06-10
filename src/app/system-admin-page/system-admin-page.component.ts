import { Component, OnInit } from '@angular/core';
import { Terms } from '../model/terms';
import { RegisterUserservice } from '../service/register-user.service';

@Component({
  selector: 'app-system-admin-page',
  templateUrl: './system-admin-page.component.html',
  styleUrls: ['./system-admin-page.component.css']
})
export class SystemAdminPageComponent implements OnInit {

   terms: Terms[] = [];
  term:Terms;
  constructor(private registerUserService: RegisterUserservice,) { }

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

}
