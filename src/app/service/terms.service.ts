import { HttpClient, HttpParams, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Terms } from '../model/terms';

@Injectable({
  providedIn: 'root',
})

export class TermsService{
    // private apiServerUrl='http://localhost:8082';

    constructor(private http: HttpClient){}

    // public getAllTerms():Observable<Terms[]>{
    //     return this.http.get<Terms[]>(`${this.apiServerUrl}/terms/all`);

    // }

    // public addTerms(terms:Terms):Observable<Terms>{
    //     return this.http.post<Terms>(`http://localhost:8082/terms/add`,terms);

    // }

    public getAllTerms():Observable<Terms[]>{
        return this.http.get<Terms[]>('http://localhost:8082/terms/all');
    }

    public addTerms(registrationRequest: any): Observable<any> {
        const token = localStorage.getItem('access_token');
        const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
        return this.http.post<Terms>(
          'http://localhost:8082/terms/add',
          registrationRequest,
          {
            headers,
          }
        );
      }

      public reserveTerms(id:any): Observable<any> {
        console.log('Here is the userID ' + id);
        const token = localStorage.getItem('access_token');
        const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
        return this.http.put<Terms>(
          `http://localhost:8082/terms/${id}/reserve`,null,
          {
            headers,
          }
        );
      }
}