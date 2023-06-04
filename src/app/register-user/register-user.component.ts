import { Component, OnInit } from '@angular/core';
import { AppointmentService } from '../service/appointment.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { MatDialog } from '@angular/material/dialog';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Statement } from '../model/statement';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Equipment } from '../model/equipment';
import { RegisterUser } from '../model/registerUser';
import { RegisterUserservice } from '../service/register-user.service';
import { Appointment } from '../model/appointment';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent implements OnInit {

  formGroup: FormGroup;
  showAddStatementPopup: boolean = false;
  showAddEquipmentPopup:boolean = false;
  statement:Statement;
  equipment:Equipment;
  id:number;
  user:RegisterUser;
  private sub: any;
  appointment:Appointment;

  constructor(private appointmentService: AppointmentService,
    private  modalService: NgbModal,
    private dialog: MatDialog, 
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private registerUserService: RegisterUserservice) { }

  ngOnInit(): void {
    this.sub = this.route.params.subscribe(params => {
      this.id = +params['id']; // (+) converts string 'id' to a number

      this.getAppointmentDetails(this.id);

      // In a real app: dispatch action to load the details here.
   });
    }
    ngOnDestroy() {
      this.sub.unsubscribe();
    }

    getAppointmentDetails(id: number) {
      this.appointmentService.getAppointmentRegisterUser(id).subscribe(
        appointment => {
          this.appointment = appointment;
        },
        error => {
          console.log('Error retrieving appointment:', error);
        }
      );
    }
   

    // this.formGroup = this.formBuilder.group({
    //   bloodType: ['', Validators.required],
    //   napomena: ['', Validators.required],
    //   bakarSulfat: [''],
    //   hemoglobinometar: [''],
    //   srce: [''],
    //   pluca: [''],
    //   krvniPritisak: [''],
    //   zahtev: [false],
    //   napomenaPregleda: [''],
    //   razlogOdbijanja: [''],
    //   mestoPunkcije: [''],
    //   kolicinaUzeteKrvi: [''],
    //   pocetakKrvi: [''],
    //   krajKrvi: ['']
    // });


    showAddStatementForm(){
      // this.id = this.registerUserService.getMeAppointment();
      console.log("appointment1234",this.id);
      this.showAddStatementPopup = true;
    }

    onSubmit() {
      // this.id = this.registerUserService.getMeAppointment();
      console.log("appointment",this.id);
      this.appointmentService.addStatements(this.id,this.statement).subscribe((Response)=>{
        location.reload();
        
      })
    }
 
    showAddEquipmentForm(){
      this.appointmentService.getId();
      this.showAddEquipmentPopup = true;
    }

}
