import { Component, OnInit } from '@angular/core';
import { Centre } from '../model/centre';
import { AuthService } from '../service/auth.service';
import { Router } from '@angular/router';
import { CentreService } from '../service/centre.service';

@Component({
  selector: 'app-all-centre-page',
  templateUrl: './all-centre-page.component.html',
  styleUrls: ['./all-centre-page.component.css']
})
export class AllCentrePageComponent implements OnInit {

  centres: Centre[];
  centre:Centre;
  name: string;
  foundUser: any;

  constructor(private authService: AuthService, private router: Router,
    private centreService:CentreService) { }

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

  searchCentre() {
    this.authService.searchCentre(this.name).subscribe(
      (response) => {
        console.log('Centre search successful');
        // Obradite odgovor na odgovarajući način
        this.foundUser = response; 
      },
      (error) => {
        console.log('Error searching centre', error);
        // Obradite grešku na odgovarajući način
      }
    );
  }

}
