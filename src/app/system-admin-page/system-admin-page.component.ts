import { Component, OnInit } from '@angular/core';
import { Terms } from '../model/terms';
import { RegisterUserservice } from '../service/register-user.service';
import { SystemAdmin } from '../model/systemAdmin';

@Component({
  selector: 'app-system-admin-page',
  templateUrl: './system-admin-page.component.html',
  styleUrls: ['./system-admin-page.component.css']
})
export class SystemAdminPageComponent implements OnInit {

   terms: Terms[] = [];
  term:Terms;
  systemAdmin: SystemAdmin;
  constructor(private registerUserService: RegisterUserservice,) { }

  ngOnInit(): void {
     this.loadRegisteredUsers();
  }

  loadRegisteredUsers() {
    this.registerUserService.getAllTerms().subscribe(
      terms => {
        this.terms = terms;
      },
      error => {
        console.log('Error occurred while fetching registered users:', error);
      }
    );
  }

}
