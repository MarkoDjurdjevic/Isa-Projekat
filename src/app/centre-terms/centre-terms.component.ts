import { Component, OnInit } from '@angular/core';
import { Centre } from '../model/centre';
import { AuthService } from '../service/auth.service';
import { CentreService } from '../service/centre.service';
import { FormDataService } from '../service/Formdata.service';

@Component({
  selector: 'app-centre-terms',
  templateUrl: './centre-terms.component.html',
  styleUrls: ['./centre-terms.component.css'],
})
export class CentreTermsComponent implements OnInit {
  constructor(
    private centreService: CentreService,
    private authService: AuthService,
    private formService: FormDataService
  ) {}
  loggedIn: boolean;
  centres: Centre[];
  date: String;
  time: string;

  ngOnInit(): void {
    this.loggedIn = this.authService.isLoggedIn;
    console.log(this.loggedIn);
    this.date = this.formService.dateInput;
    this.time = this.formService.timeInput;
    console.log(`Date:`, this.date, `TIME`, this.time);
    this.centreService
      .getAvailableCentres(this.date, this.time)
      .subscribe((response: Centre[]) => {
        this.centres = response;
        console.log('OVO JE REZULTAT', this.centres);
      });
  }
  showData() {}
}
