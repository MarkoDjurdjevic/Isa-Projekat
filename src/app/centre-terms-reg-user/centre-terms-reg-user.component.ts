import { Component, inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BloodType } from '../enums/BloodType';
import { Appointment } from '../model/appointment';
import { Centre } from '../model/centre';
import { AppointmentService } from '../service/appointment.service';
import { AuthService } from '../service/auth.service';
import { CentreService } from '../service/centre.service';
import { FormDataService } from '../service/Formdata.service';

@Component({
  selector: 'app-centre-terms-reg-user',
  templateUrl: './centre-terms-reg-user.component.html',
  styleUrls: ['./centre-terms-reg-user.component.css'],
})
export class CentreTermsRegUserComponent implements OnInit {
  constructor(
    private centreService: CentreService,
    private authService: AuthService,
    private formService: FormDataService,
    private appointmentService: AppointmentService,
    private router: Router
  ) {}
  loggedIn: boolean;
  centres: Centre[];
  date: String;
  time: string;
  duration: number;
  available: boolean;
  newAppointment: Appointment;
  formularSigned: boolean;
  lastDonation: boolean;
  //id: number = 6;

  ngOnInit(): void {
    //provera da li je formular potpisan
    this.formularSigned = this.appointmentService.bloodFormular;
    //provera da li je krv donirana u protekla 6 meseca
    this.lastDonation = this.appointmentService.lastDonation;
    console.log(`poslednja donacija: `, this.lastDonation);
    console.log(`potpisan formula: `, this.formularSigned);
    this.loggedIn = this.authService.isLoggedIn;
    console.log(this.loggedIn);
    this.date = this.formService.dateInput;
    this.time = this.formService.timeInput;
    console.log(`Date:`, this.date, `TIME`, this.time);

    this.centreService
      .getAvailableCentresRegUser(this.date, this.time)
      .subscribe((response: Centre[]) => {
        this.centres = response;
        console.log('OVO JE REZULTAT', this.centres);
      });
  }

  addAppointment(centre: Centre) {
    this.centreService.getCentreById(centre.id).subscribe((centre) => {
      this.appointmentService.getAppointments().subscribe((appointments) => {
        for (let i = 0; i < appointments.length; i++) {
          if (
            appointments[i].time === this.time &&
            appointments[i].centreId == centre.id
          ) {
            //this.time
            appointments[i].available = false;
            let updatedAppointment = { ...appointments[i], available: false }; //dodao
            console.log(updatedAppointment);
            this.appointmentService
              .updateAppointment(updatedAppointment) //.updateAppointment(appointments[i])
              .subscribe();
          }
        }
      });
    });
  }

  sortCentres() {
    this.centres.sort((a, b) => b.avgGrade - a.avgGrade);
  }
  navigatetoFormular() {
    this.router.navigate(['/blood-formular']);
  }
}
