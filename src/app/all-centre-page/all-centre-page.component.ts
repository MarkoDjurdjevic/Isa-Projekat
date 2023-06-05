import { Component, OnInit } from '@angular/core';
import { Centre } from '../model/centre';
import { AuthService } from '../service/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-all-centre-page',
  templateUrl: './all-centre-page.component.html',
  styleUrls: ['./all-centre-page.component.css']
})
export class AllCentrePageComponent implements OnInit {

  centres: Centre[];
  centre:Centre;

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
    this.loadCentre();
  }

  loadCentre(){
    this.authService.getCentres().subscribe(
      users => {
        this.centres = users;
      },
      error => {
        console.log('Error occurred while fetching registered users:', error);
      }
    );
  }

}
