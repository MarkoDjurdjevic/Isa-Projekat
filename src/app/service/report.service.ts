import { Injectable } from '@angular/core';
import { Report } from '../model/report';
import { Observable } from 'rxjs';
import { HtmlTagDefinition } from '@angular/compiler';
import { HttpClient, HttpParams} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReportService {


 

  constructor(private http: HttpClient) { }

  public addReport(report:Report):Observable<Report>{
    return this.http.post<Report>(`http://localhost:8082/report/add`,report);
  }

  ///proveriti bekendd!!!!!!
















}
