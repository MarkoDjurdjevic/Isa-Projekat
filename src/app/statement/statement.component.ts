import { Component, OnInit } from '@angular/core';
import { catchError, map, Observable, of } from 'rxjs';
import { Subscription } from 'rxjs';
import { FormBuilder, FormGroup, NgForm } from '@angular/forms';
import { HttpClient,HttpErrorResponse,  HttpClientModule } from '@angular/common/http'; // importujemo HttpClient
import { BloodType } from '../enums/BloodType';
import { StatementService } from '../service/statement.service';
import { AppointmentService } from '../service/appointment.service';
import { Appointment } from '../model/appointment';
import { TermsAdminComponent } from '../terms-admin/terms-admin.component';


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
  appointment: Appointment;
  // appointmentid:number;
  id:number;

  constructor(private http: HttpClient,
    private formBuilder:FormBuilder,
    private statementService: StatementService,
    private appontmentService: AppointmentService) { }

  ngOnInit(): void {
  }

  addReport(form:NgForm){
    const statement = form.value;
    console.log("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    this.id = this.appontmentService.getId();
    console.log(this.id);
    this.appontmentService.addStatements(this.id,statement).subscribe((response)=>{

      console.log("uspesno je");
      location.reload();
    })

  }

  
  addEquipment(form:NgForm){
    const equipment = form.value;
    console.log("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    this.id = this.appontmentService.getId();
    console.log(this.id);
    this.appontmentService.addStatements(this.id,equipment).subscribe((response)=>{

      console.log("uspesno je");
      location.reload();
    })


  }

}
