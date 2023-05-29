import { Injectable } from '@angular/core';
import { HttpClient, HttpParams} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Blood } from '../model/blood';

@Injectable({
  providedIn: 'root'
})
export class BloodService {

  constructor(private http:HttpClient) { }

  public addBlood(blood:Blood):Observable<Blood>{
    return this.http.post<Blood>('http://localhost:8082/centre/blood/add',blood);
  }

  public getAllBlood():Observable<Blood[]>{
    return this.http.get<Blood[]>('http://localhost:8082/centre/blood/all');
  }
}
