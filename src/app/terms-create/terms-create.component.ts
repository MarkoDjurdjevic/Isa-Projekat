import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormControl} from '@angular/forms';
import { Terms } from '../model/terms'; // importujemo Terms model
import { HttpClient,HttpErrorResponse,  HttpClientModule } from '@angular/common/http'; // importujemo HttpClient
import { Users } from '../model/user';
import { TermsService } from '../service/terms.service';
import { Subscription } from 'rxjs';
import { FormBuilder, FormGroup, NgForm } from '@angular/forms';
import { AuthService } from '../service/auth.service';
import { UserService } from '../service/user.service';
import { UsersDTO } from '../model/userDTO';

@Component({
  selector: 'app-terms-create',
  templateUrl: './terms-create.component.html',
  styleUrls: ['./terms-create.component.css']
})
export class TermsCreateComponent implements OnInit {
  
 user: Users[];
 terms: Terms[];
 term: Terms;
 addingTerms = false;
 subscribe:Subscription;
 response : Response;
 loggedIn: boolean;
 selectedUser: number;

  constructor(private http: HttpClient,
    private termsService: TermsService,
    private formBuilder:FormBuilder,
    private authService: AuthService,
    private userService: UserService
    ) { }

  ngOnInit(): void {


    this.userService.getCentreAdministrators().subscribe((response: Users[]) => {
      this.user = response;
    });
    // this.userService.getUsers().subscribe((response: Users[]) => {
    //   this.user = response;
    // });
    this.termsService.getAllTerms().subscribe((response: Terms[]) => {
      this.terms = response;
      this.loggedIn = this.authService.isLoggedIn;
      console.log(this.loggedIn);
    });
   
  }
  openAddTermForm() {
    this.addingTerms = true;
  }

  addTerms(form: NgForm){
    const term = form.value;
    this.termsService.addTerms(term).subscribe((response)=>{
      console.log('Terms was succesfully added');
      location.reload();
    });
      
    }

  }

  


