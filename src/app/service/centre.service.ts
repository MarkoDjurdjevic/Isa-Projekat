import { Injectable } from '@angular/core';
import {
  HttpClient,
  HttpErrorResponse,
  HttpParams,
} from '@angular/common/http';
import { catchError, map, Observable, of } from 'rxjs';
import { Centre } from '../model/centre';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CentreService {
  constructor(private http: HttpClient) {}
  startedEditing = new Subject<number>();

  getCentres(): Observable<Centre[]> {
    return this.http.get<Centre[]>('http://localhost:8082/centre/all');
  }

  getCentreById(id: number): Observable<Centre> {
    return this.http.get<Centre>(`http://localhost:8082/centre/${id}`);
  }

  getAvailableCentres(
    date: String,
    time: string,
    duration: number
  ): Observable<Centre[]> {
    return this.http.get<Centre[]>(
      `http://localhost:8082/centre/appointments?date=${date}&time=${time}&duration=${duration}`

      //`http://localhost:8082/centre/appointments`
    );
  }

  getAvailableCentresRegUser(date: String, time: string): Observable<Centre[]> {
    return this.http.get<Centre[]>(
      `http://localhost:8082/centre/appointments1?date=${date}&time=${time}`

      //`http://localhost:8082/centre/appointments`
    );
  }

  public registerNewCentre(centre: Centre): Observable<Centre> {
    return this.http.post<Centre>('http://localhost:8082/centre/add', centre);
  }

  public deleteCentre(centreId: number): Observable<void> {
    return this.http.delete<void>(
      `http://localhost:8082/centre/delete/${centreId}`
    );
  }

  public updateCentre(id: number, centre: Centre): Observable<Centre> {
    console.log(`Updating centre with id ${id} and centre object`, centre);
    return this.http.put<Centre>(
      'http://localhost:8082/centre/update/' + id,
      centre
    );
  }

  //slight errors here
  public searchCentres(
    name: string,
    adress: string
  ): Observable<Centre | null> {
    let params = new HttpParams().set('name', name).set('adress', adress);

    return this.http
      .get<Centre>('http://localhost:8082/centre/search', { params })
      .pipe(
        catchError((error: HttpErrorResponse) => {
          if (error.status === 404) {
            return of<Centre>(null);
          } else {
            throw error;
          }
        })
      );
  }
}
