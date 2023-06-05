import { Component, OnInit } from '@angular/core';
import { AppointmentService } from '../service/appointment.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { MatDialog } from '@angular/material/dialog';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Statement } from '../model/statement';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
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
  appointmnetId:number;
  zahtev: boolean;
  isAvailable: boolean = true;

  constructor(private appointmentService: AppointmentService,
    private  modalService: NgbModal,
    private dialog: MatDialog, 
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private registerUserService: RegisterUserservice,
    private router:Router,) { }

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
          this.appointmnetId = appointment.id;
        },
        error => {
          console.log('Error retrieving appointment:', error);
        }
      );
    }
   

    showAddStatementForm(id:number){  
      this.router.navigate(['/statement/',id]);
    }

    onSubmit() {
      this.appointmentService.addStatements(this.appointmnetId,this.statement).subscribe((Response)=>{
        console.log("appointment",this.appointmnetId);
        location.reload();
        
      })
    }
 
    showAddEquipmentForm(id:number){
      this.router.navigate(['/equipment-appointment/',id]);
    }

    updateAppointmentAvailability(id: number) {
      this.isAvailable = !this.isAvailable; // Promeni vrednost na suprotno stanje
      const appointment1 = this.appointment;
      this.appointmentService.updateAvailability(id).subscribe(
        (response) => {
          console.log('Availability updated successfully');
        },
        (error) => {
          console.log('Error updating availability', error);
        }
      );
    }
  

}
