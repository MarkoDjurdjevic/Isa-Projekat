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
import { Statement } from '../model/statement';
import { ActivatedRoute } from '@angular/router';


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
  statement:Statement;
  private sub: any;
  showSuccessMessage = false;

  constructor(private http: HttpClient,
    private formBuilder:FormBuilder,
    private statementService: StatementService,
    private appontmentService: AppointmentService,
    private route: ActivatedRoute,
    private appointmentService: AppointmentService) { }

  ngOnInit(): void {
    this.sub = this.route.params.subscribe(params => {
      this.id = +params['id']; // (+) converts string 'id' to a number
      // In a real app: dispatch action to load the details here.
   });

    
  }
  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  // addReport(form:NgForm){
  //   const statement = form.value;
  //   console.log("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
  //   this.id = this.appontmentService.getId();
  //   console.log(this.id);
  //   this.appontmentService.addStatements(this.id,statement).subscribe((response)=>{

  //     console.log("uspesno je");
  //     location.reload();
  //   })

  // }

  
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
  submitForm(form: NgForm){
    const registrationRequest = {
      napomena: form.value.napomena,
      bakarSulfat: form.value.bakarSulfat,
      time: form.value.time,
      hemoglobinometar: form.value.hemoglobinometar,
      srce: form.value.srce,
      pluca: form.value.pluca,
      krvniPritisak: form.value.krvniPritisak,
      napomenaPregleda: form.value.napomenaPregleda,
      razlogOdbijanja: form.value.razlogOdbijanja,
      zahtev: form.value.zahtev,
      mestoPunkcije: form.value.mestoPunkcije,
      kolicinaUzeteKrvi: form.value.kolicinaUzeteKrvi,
      pocetakKrvi: form.value.pocetakKrvi,
      krajKrvi: form.value.krajKrvi,
      bloodTypeName: form.value.bloodTypeName
    };
    this.appointmentService.addStatements(this.id,registrationRequest).subscribe(
      (response) => {
        console.log('User successfully registered');
        
      },
      (error) => {
        console.log('Error registering user', error);
      }
    );

  }

}
