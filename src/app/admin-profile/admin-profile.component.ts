import { Component, OnInit } from '@angular/core';
import { CentreService } from '../service/centre.service';
import { CentreAdmin } from '../model/centreAdmin';

@Component({
  selector: 'app-admin-profile',
  templateUrl: './admin-profile.component.html',
  styleUrls: ['./admin-profile.component.css']
})
export class AdminProfileComponent implements OnInit {

  centreAdmin: CentreAdmin;

  constructor(private centreService: CentreService) { }

  ngOnInit(): void {
    this.getCentreAdmin();
  }

  getCentreAdmin() {
    this.centreService.getCentreAdmin().subscribe(
      (response) => {
        this.centreAdmin = response;
      },
      (error) => {
        console.log('Greška prilikom dohvatanja podataka o CentreAdmin korisniku', error);
      }
    );
  }
}
