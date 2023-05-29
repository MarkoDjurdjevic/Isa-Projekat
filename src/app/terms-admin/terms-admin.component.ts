import { Component, OnInit } from '@angular/core';
import { AppointmentService } from '../service/appointment.service';
import { Appointment } from '../model/appointment';
import { HttpClient,HttpErrorResponse,  HttpClientModule } from '@angular/common/http'; // importujemo HttpClient
import { Router } from '@angular/router';


@Component({
  selector: 'app-terms-admin',
  templateUrl: './terms-admin.component.html',
  styleUrls: ['./terms-admin.component.css']
})
export class TermsAdminComponent implements OnInit {

  appointments:Appointment[];
  response : Response;
  appointment: Appointment;

  constructor(private appointmentService: AppointmentService,
    private router:Router) { }

  ngOnInit(): void {
    console.log("aaaaaaaa1");
    this.appointmentService.getAppointments().subscribe((response : Appointment[])=>{
      this.appointments = response;
    });


  }

  goToReport(){
    this.router.navigateByUrl('/statement');
  }



}
