import { Injectable } from '@angular/core';
import { Report } from '../model/report';
import { Observable } from 'rxjs';
import { HtmlTagDefinition } from '@angular/compiler';
import { HttpClient, HttpParams} from '@angular/common/http';
import { User } from '../model/user';
import { RegisterUser } from '../model/registerUser';
import { HttpHeaders } from '@angular/common/http';
import { Terms } from '../model/terms';

@Injectable({
  providedIn: 'root'
})
export class RegisterUserservice {

  user: RegisterUser;
  registerId:number;

  constructor(private http: HttpClient) { }


  public registerUserByAppointment(): Observable<RegisterUser[]> {
    const token = localStorage.getItem('access_token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get<RegisterUser[]>('http://localhost:8082/registerUser/allRegisterUser', {
      headers,
    });
  }

  public registerUserById(userId: number): Observable<RegisterUser> {
    const token = localStorage.getItem('access_token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get<RegisterUser>(`http://localhost:8082/registerUser/allRegisterUser/${userId}`, {
      headers,
    });
  }

  getMeRegisterUser(id:number){
    this.registerUserById(id).subscribe((response: RegisterUser) =>
    {
      this.user = response;
      
    });
    this.user.appointments.id = id;
    console.log("neki id mars", id)
    return id;
  }

  public getAllTerms(): Observable<Terms[]> {
    const token = localStorage.getItem('access_token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get<Terms[]>('http://localhost:8082/terms/allTermsList', {
      headers,
    });
  }

  rateForCenter(rateForCentre: any): Observable<any> {
    const token = localStorage.getItem('access_token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.post<any>(
      `http://localhost:8082/centre/rate`,
      rateForCentre,
      {
        headers,
      }
    );
  }

  // public getAppointmentId(id: number){
  //   this.user = this.getMeRegisterUser(id);
  //   this.user.appointments.id = this.registerId;
  //   return this.registerId;
  // }



}