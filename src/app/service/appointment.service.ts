import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Appointment } from '../model/appointment';
import { Statement } from '../model/statement';

@Injectable({
  providedIn: 'root',
})
export class AppointmentService {
  constructor(private http: HttpClient) {}
  bloodFormular = false;
  lastDonation = false;
  appointment: Appointment;
  appointmentId: number;

  public addAppointment(appointment: Appointment): Observable<Appointment> {
    return this.http.post<Appointment>(
      'http://localhost:8082/appointments/add',
      appointment
    );
    console.log(`trebalo bi da sam uspesno napravio appointment`);
  }

  getAppointmentById(id: number): Observable<Appointment> {
    return this.http.get<Appointment>(
      `http://localhost:8082/appointments/${id}`
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

  public addStatements(id:number,statement: Statement): Observable<Statement>{
    statement.appointmentId = id;
    console.log(id, "aaaaaaaaaaaaaaaaaa");
      return this.http.post<Statement>( `http://localhost:8082/appointments/${id}/add`,statement);
    }

 

    getMeAppointmentID(id: number){
       this.getAppointmentById(id).subscribe((response: Appointment)=>{
          this.appointment = response});
      //  this.appointment.id = id;
      console.log(id,"da li radis")
      this.appointmentId = id;
      console.log(this.appointmentId, "mamama mia");
       return this.appointmentId;
    
  }

  public getId(){
    return this.appointmentId;
  }

  lastDonationMethod(value: boolean) {
    this.lastDonation = value;
  }

  bloodFormularMethod() {
    this.bloodFormular = true;
  }
}
