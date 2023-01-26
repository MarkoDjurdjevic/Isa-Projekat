import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Appointment } from '../model/appointment';

@Injectable({
  providedIn: 'root',
})
export class AppointmentService {
  constructor(private http: HttpClient) {}
  bloodFormular = false;
  lastDonation = false;

  public addAppointment(appointment: Appointment): Observable<Appointment> {
    return this.http.post<Appointment>(
      'http://localhost:8082/appointments/add',
      appointment
    );
    console.log(`trebalo bi da sam uspesno napravio appointment`);
  }

  getAppointmentById(id: number): Observable<Appointment> {
    return this.http.get<Appointment>(
      `'http://localhost:8082/appointments/${id}`
    );
  }

  getAppointments(): Observable<Appointment[]> {
    return this.http.get<Appointment[]>(
      'http://localhost:8082/appointments/all'
    );
  }

  public updateAppointment(appointment: Appointment): Observable<Appointment> {
    console.log(`Updating Appointment  object`, appointment);
    return this.http.put<Appointment>(
      'http://localhost:8082/appointments/update/',
      appointment
    );
  }

  lastDonationMethod(value: boolean) {
    this.lastDonation = value;
  }

  bloodFormularMethod() {
    this.bloodFormular = true;
  }
}
