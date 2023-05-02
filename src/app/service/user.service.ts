import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Users } from '../model/user';
import { UsersDTO } from '../model/userDTO';

@Injectable({ providedIn: 'root' })
export class UserService {
  constructor(private http: HttpClient) {}
  loggedInUser: Users;
  users: UsersDTO;

  getUsers(): Observable<Users[]> {
    return this.http.get<Users[]>('http://localhost:8082/users/all');
  }

  login(email: string, password: string): Observable<Users> {
    return this.http.post<Users>('http://localhost:8082/users/login', {
      email,
      password,
    });
  }

  updateUser(id: number, users: UsersDTO): Observable<Users> {
    return this.http.put<Users>(
      'http://localhost:8082/users/update/' + id,
      users
    );
  }

  getCentreAdministrators(): Observable<Users[]>{
      return this.http.get<Users[]>('http://localhost:8082/users/allCentreAdministartors');
  }
}
