import { Component, OnInit } from '@angular/core';
import { AppointmentService } from '../service/appointment.service';
import { ActivatedRoute, Router } from '@angular/router';
import { NgFor } from '@angular/common';
import { NgForm } from '@angular/forms';
import { Appointment } from '../model/appointment';

@Component({
  selector: 'app-availability-page',
  templateUrl: './availability-page.component.html',
  styleUrls: ['./availability-page.component.css']
})
export class AvailabilityPageComponent implements OnInit {
  private sub: any;
  id:number;
  appointment:Appointment;
  available:boolean;

  constructor(private appointmentService: AppointmentService,
    private route: ActivatedRoute,
    private router:Router,) { }

  ngOnInit(): void {
    this.sub = this.route.params.subscribe(params => {
      this.id = +params['id']; // (+) converts string 'id' to a number

      // In a real app: dispatch action to load the details here.
   });
  }

  // submitForm(form: NgForm){
  //   const registrationRequest = {
  //     available: form.value.available,
  //   };
  //   this.appointmentService.updateAvailability(this.id,registrationRequest).subscribe(
  //     (response) => {
  //       console.log('User successfully registered');
  //     },
  //     (error) => {
  //       console.log('Error registering user', error);
  //     }
  //   );

  // }

}
