import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';
import { UsersDTO } from '../model/userDTO';

@Injectable({ providedIn: 'root' })
export class UserService {
  constructor(private http: HttpClient) {}
  loggedInUser: User;
  users: UsersDTO;

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>('http://localhost:8082/users/all');
  }

  login(email: string, password: string): Observable<User> {
    return this.http.post<User>('http://localhost:8082/users/login', {
      email,
      password,
    });
  }

  public updateUser(registrationRequest: any): Observable<any> {
    const token = localStorage.getItem('access_token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.put<User>(
      'http://localhost:8082/userapp/update/',
      registrationRequest,
      {
        headers,
      }
    );
  }

  getCentreAdministrators(): Observable<User[]>{
      return this.http.get<User[]>('http://localhost:8082/users/allCentreAdministartors');
  }

  getAllRegisterUsers():Observable<User[]>{
    return this.http.get<User[]>('http://localhost:8082/users/allRegisterUsers');
  }
}
