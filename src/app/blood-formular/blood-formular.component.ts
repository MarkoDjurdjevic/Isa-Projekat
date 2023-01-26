import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { AppointmentService } from '../service/appointment.service';

@Component({
  selector: 'app-blood-formular',
  templateUrl: './blood-formular.component.html',
  styleUrls: ['./blood-formular.component.css'],
})
export class BloodFormularComponent implements OnInit {
  constructor(
    private router: Router,
    private appointmentService: AppointmentService
  ) {}
  @ViewChild('lastDonation') lastDonation: ElementRef;

  ngOnInit(): void {}

  onSubmit() {
    console.log(`working`);
    const lastDonationValue = this.lastDonation.nativeElement.checked;
    this.appointmentService.lastDonationMethod(lastDonationValue);
    this.appointmentService.bloodFormularMethod();
    this.router.navigate([`/centres-terms-reg-user`]);
  }
}
