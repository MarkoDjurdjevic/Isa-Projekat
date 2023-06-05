
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
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-equipment-appointment',
  templateUrl: './equipment-appointment.component.html',
  styleUrls: ['./equipment-appointment.component.css']
})
export class EquipmentAppointmentComponent implements OnInit {

  id:number;
    private sub: any;

  constructor(private http: HttpClient,
    private formBuilder:FormBuilder,
    private statementService: StatementService,
    private route: ActivatedRoute,
    private appontmentService: AppointmentService) { }

  ngOnInit(): void {
    this.sub = this.route.params.subscribe(params => {
      this.id = +params['id']; // (+) converts string 'id' to a number
      // In a real app: dispatch action to load the details here.
   });
  }
    ngOnDestroy() {
    this.sub.unsubscribe();
  }

  addEquipment(form:NgForm){
    const equipment = form.value;
    console.log("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    this.id = this.appontmentService.getId();
    console.log(this.id);
    this.appontmentService.registerNewEquipment(this.id,equipment).subscribe((response)=>{

      console.log("uspesno je");
      location.reload();
    })


  }

  submitForm(form: NgForm){
    const registrationRequest = {
      nameEquipment: form.value.nameEquipment,
      quantitiofEquipment: form.value.quantitiofEquipment,
      
    };
    this.appontmentService.registerNewEquipment(this.id,registrationRequest).subscribe(
      (response) => {
        console.log('User successfully registered');
      },
      (error) => {
        console.log('Error registering user', error);
      }
    );

  }

}
