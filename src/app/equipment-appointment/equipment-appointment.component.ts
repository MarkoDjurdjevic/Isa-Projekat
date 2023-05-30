
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
  selector: 'app-equipment-appointment',
  templateUrl: './equipment-appointment.component.html',
  styleUrls: ['./equipment-appointment.component.css']
})
export class EquipmentAppointmentComponent implements OnInit {

  id:number;

  constructor(private http: HttpClient,
    private formBuilder:FormBuilder,
    private statementService: StatementService,
    private appontmentService: AppointmentService) { }

  ngOnInit(): void {
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
