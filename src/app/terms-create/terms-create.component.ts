import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormControl, FormGroup } from '@angular/forms';
import { Terms } from '../model/terms'; // importujemo Terms model
import { HttpClient } from '@angular/common/http'; // importujemo HttpClient
import { Users } from '../model/user';

@Component({
  selector: 'app-terms-create',
  templateUrl: './terms-create.component.html',
  styleUrls: ['./terms-create.component.css']
})
export class TermsCreateComponent implements OnInit {
  createTermsform: FormGroup;
  usersList=[];


  //pravimo objekte
  terms:Terms={
    id: 0,
    date: '',
    time: '',
    duration: '',
    //medicalUsers: []
  };

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.buildForm();
    //this.loadUsers();
  }

  buildForm(){
    this.createTermsform = new FormGroup({
      date: new FormControl(''),
      time: new FormControl(''),
      duration: new FormControl(''),
      medicalUsers: new FormControl(''),
      
    });
    console.log("Objekat je kreiran");
  }

  // loadUsers(){
  //   this.http.get<MedicalUsers>('http://localhost:8082/users/all').subscribe(
  //     (response) => {
  //       console.log(response);
  //       this.usersList = response;
  //       // prikazujemo samo imena korisnika
  //       this.terms.medicalUsers = this.usersList.map(user => user.id);
  //       console.log(this.terms.medicalUsers);
  //     },
  //     (error) => {
  //       console.log(error);
  //     }
  //   );
  

  //}

}
