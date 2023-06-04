import { Injectable } from '@angular/core';
import { HttpClient, HttpParams} from '@angular/common/http';
import { Statement } from '../model/statement';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StatementService {

  constructor(private http: HttpClient) { }


}
