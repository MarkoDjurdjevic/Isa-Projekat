import { HttpClient, HttpParams} from '@angular/common/http';
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

    public addTerms(terms:Terms):Observable<Terms>{
        return this.http.post<Terms>(`http://localhost:8082/terms/add`,terms);

    }

    public getAllTerms():Observable<Terms[]>{
        return this.http.get<Terms[]>('http://localhost:8082/terms/all');
    }
}