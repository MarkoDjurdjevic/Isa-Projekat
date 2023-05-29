import { Component, OnInit } from '@angular/core';
import { catchError, map, Observable, of } from 'rxjs';
import { Subscription } from 'rxjs';
import { FormBuilder, FormGroup, NgForm } from '@angular/forms';
import { HttpClient,HttpErrorResponse,  HttpClientModule } from '@angular/common/http'; // importujemo HttpClient
import { BloodType } from '../enums/BloodType';
import { StatementService } from '../service/statement.service';


@Component({
  selector: 'app-statement',
  templateUrl: './statement.component.html',
  styleUrls: ['./statement.component.css']
})
export class StatementComponent implements OnInit {

  addingReport= false;
  subscribe:Subscription;
  response: Response;
  bloodTypes = Object.values(BloodType);
  zahtev: boolean = false;

  constructor(private http: HttpClient,
    private formBuilder:FormBuilder,
    private statementService: StatementService) { }

  ngOnInit(): void {
  }

  openFormStatement(){
    this.addingReport = true;
  }

  addReport(form:NgForm){
    const statement = form.value;
    this.statementService.addStatement(statement).subscribe((response)=>{
      location.reload();
    })

  }

}
