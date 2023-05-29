import { Injectable } from '@angular/core';
import { HttpClient, HttpParams} from '@angular/common/http';
import { Statement } from '../model/statement';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StatementService {

  constructor(private http: HttpClient) { }

  public addStatement(statement:Statement): Observable<Statement>{
    return this.http.post<Statement>(`http://localhost:8082/statements/add`,statement);
  }
}
