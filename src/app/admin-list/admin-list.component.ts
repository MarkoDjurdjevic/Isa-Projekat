import { Component, OnInit } from '@angular/core';
import { CentreService } from '../service/centre.service';
import { CentreAdmin } from '../model/centreAdmin';

@Component({
  selector: 'app-admin-list',
  templateUrl: './admin-list.component.html',
  styleUrls: ['./admin-list.component.css']
})
export class AdminListComponent implements OnInit {

  registeredUsers: CentreAdmin[] = [];

  constructor(private centreService:CentreService) { }

  ngOnInit(): void {
    this.loadCentreAdmin();
  }

  loadCentreAdmin() {
    this.centreService.getAllCentreAdmin().subscribe(
      users => {
        this.registeredUsers = users;
      },
      error => {
        console.log('Error occurred while fetching registered users:', error);
      }
    );
  }

}
