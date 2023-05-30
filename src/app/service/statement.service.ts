import { Injectable } from '@angular/core';
import { HttpClient, HttpParams} from '@angular/common/http';
import { Statement } from '../model/statement';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StatementService {

  constructor(private http: HttpClient) { }


  // getAppointmentById(id: number): Observable<Appointment> {
  //   return this.http.get<Appointment>(
  //     `'http://localhost:8082/appointments/${id}`
  //   );
  // }

  // public addStatements(statement: Statement): Observable<Statement>{
  //   return this.http.post<Statement>( `http://localhost:8082/appointments/${id}/add`,statement);
  // }
}
