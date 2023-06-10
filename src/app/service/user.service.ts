import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';
import { UsersDTO } from '../model/userDTO';
import { tap } from 'rxjs/operators';

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

  getAllUsers():Observable<User[]>{
    const token = localStorage.getItem('access_token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get<User[]>('http://localhost:8082/userapp/listOfAllUsers',
    {
      headers,
    }
    );
  }

  searchUser(name: string, lastname: string): Observable<any> {
    const token = localStorage.getItem('access_token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get<any>(
      `http://localhost:8082/userapp/searchUser?name=${name}&lastname=${lastname}`, {
        headers,
      }).pipe(
        tap(response => console.log(response)) // Dodajte ovaj deo za ispis odgovora u konzoli
      );
  }
}
