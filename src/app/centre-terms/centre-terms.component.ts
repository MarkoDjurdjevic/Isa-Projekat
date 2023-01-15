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
  selector: 'app-centre-terms',
  templateUrl: './centre-terms.component.html',
  styleUrls: ['./centre-terms.component.css'],
})
export class CentreTermsComponent implements OnInit {
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
      .getAvailableCentres(this.date, this.time)
      .subscribe((response: Centre[]) => {
        this.centres = response;
        console.log('OVO JE REZULTAT', this.centres);
      });
  }

  // incrementId() {
  //   this.id = this.id + 1;
  // }

  addAppointment(centre: Centre) {
    // this.incrementId();

    this.newAppointment = {
      // id: this.id,
      date: this.date,
      time: this.time,
      bloodType: BloodType.APOS,
      centreId: centre.id,
    };

    //centre.appointmentIds.push(this.newAppointment.id);
    this.appointmentService.addAppointment(this.newAppointment).subscribe(
      (response: Appointment) => {
        console.log(`Successfully added appointment`);
        console.log(response);
      },
      (error) => {
        console.log(`Error adding appointment`);
        console.log(error);
      }
    );

    // this.centreService.updateCentre(centre.id, centre).subscribe(
    //   (response: Centre) => {
    //     console.log(`Successfully updated centre with new appointment`);
    //     console.log(response);
    //   },
    //   (error) => {
    //     console.log('Error updating centre with new appointment', error);
    //   }
    // );
  }

  sortCentres() {
    this.centres.sort((a, b) => b.avgGrade - a.avgGrade);
  }
  navigatetoFormular() {
    this.router.navigate(['/blood-formular']);
  }
}
