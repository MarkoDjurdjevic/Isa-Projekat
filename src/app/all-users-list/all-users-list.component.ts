import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { User } from '../model/user';

@Component({
  selector: 'app-all-users-list',
  templateUrl: './all-users-list.component.html',
  styleUrls: ['./all-users-list.component.css']
})
export class AllUsersListComponent implements OnInit {

  usersList:User[];
  foundUser: any;
  name: string;
  lastname: string;

  constructor(private userService: UserService) { }

  ngOnInit(): void {

    this.loadAllUsers();
  }

  loadAllUsers() {
    this.userService.getAllUsers().subscribe(
      users => {
        this.usersList = users;
      },
      error => {
        console.log('Error occurred while fetching registered users:', error);
      }
    );
  }

  searchUser(){

    this.userService.searchUser(this.name, this.lastname).subscribe(
      (response) => {
        console.log('Centre search successful');
        this.foundUser = response; 
      },
      (error) => {
        console.log('Error searching centre', error);
      }
    );


  }

}
