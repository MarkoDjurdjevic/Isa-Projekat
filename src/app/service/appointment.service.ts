import { HttpClient,HttpHeaders } from '@angular/common/http';
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

  addStatements(id:number,statement: any): Observable<any[]> {
    const token = localStorage.getItem('access_token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.post<any[]>(
      `http://localhost:8082/appointments/${id}/add`,
      statement,
      {
        headers,
      }
    );
  }

  registerNewEquipment(id:number,equipment: any): Observable<any[]> {
    const token = localStorage.getItem('access_token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.post<any[]>(
      `http://localhost:8082/appointments/${id}/addEquipment`,
      equipment,
      {
        headers,
      }
    );
  }

  public updateAvailability(id: number, appointment: Appointment): Observable<any> {
    const token = localStorage.getItem('access_token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.put<any>(`http://localhost:8082/appointments/${id}/updateAvailability`, appointment
    ,{
      headers,
    });
  }

  public getAppointmentRegisterUser(id: number): Observable<Appointment> {
    const token = localStorage.getItem('access_token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get<Appointment>(`http://localhost:8082/appointments/${id}/getAppointmentRegisterUser`, {
      headers,
    });
  }
}
