import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import {
  HttpClient,
  HttpClientModule,
  HttpErrorResponse,
} from '@angular/common/http';
import { AppService } from '../app.service';
import { CentreService } from '../service/centre.service';
import { Centre } from '../model/centre';
import { Subscription } from 'rxjs';
import { FormBuilder, FormGroup, NgForm } from '@angular/forms';
import { UserService } from '../service/user.service';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-centre',
  templateUrl: './centre.component.html',
  styleUrls: ['./centre.component.css'],
})
export class CentreComponent implements OnInit, OnDestroy {
  title = 'isa-angular-projekat';
  centres: Centre[];
  subscription: Subscription;
  editMode = false;
  editedItemIndex: number;
  editedItem: Centre;
  editCentreForm: FormGroup;
  editing = false;
  centre: Centre;
  addingCentre = false;
  deleteMode = false;
  loggedIn: boolean;
  filteredCenters: Centre[];

  constructor(
    private centreService: CentreService,
    private fb: FormBuilder,
    private authService: AuthService
  ) {
    this.editCentreForm = this.fb.group({
      id: [''],
      name: [''],
      adress: [''],
      description: [''],
      avgGrade: [''],
    });
  }

  ngOnInit() {
    this.centreService.getCentres().subscribe((response: Centre[]) => {
      this.centres = response;
      this.filteredCenters = this.centres;
      console.log(`filterovani centri: `, this.filteredCenters);
      console.log(response);
      console.log(`Centri: `, this.centres);
      this.loggedIn = this.authService.isLoggedIn;
      console.log(this.loggedIn);
    });

    this.subscription = this.centreService.startedEditing.subscribe(
      (index: number) => {
        this.editedItemIndex = index;
        this.editMode = true;
        this.editedItem = this.getCentre(index);

        console.log(this.editedItem);
      }
    );
  }

  onEdit(index: number) {
    this.centreService.startedEditing.next(index);
    this.editing = true;
    this.centre = this.centres[index];
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  getCentre(index: number) {
    return this.centres[index];
  }

  onSubmit() {
    const updatedCentre = this.editCentreForm.value;
    console.log(updatedCentre);
    this.centres[this.editedItemIndex] = updatedCentre;
    this.centreService.updateCentre(updatedCentre.id, updatedCentre).subscribe(
      (response: Centre) => {
        console.log(`Response from updateCentre:`, response);
      },
      (error) => {
        console.error(error);
      }
    );
    this.editMode = false;
    this.editCentreForm.reset();
    this.editing = false;
  }

  onDelete(i: number) {
    this.deleteMode = true;
    const deleteCentre = this.centres[i];
    console.log(deleteCentre);
    this.centreService.deleteCentre(deleteCentre.id).subscribe((res) => {
      console.log('Centre was succesfully deleted');
      location.reload();
    });
  }

  openAddCentreForm() {
    this.addingCentre = true;
  }

  addCentreForm(form: NgForm) {
    const centre = form.value;
    this.centreService.registerNewCentre(centre).subscribe((res) => {
      console.log('Centre was succesfully added');
      location.reload();
    });
  }

  search(name: string, adress: string) {
    this.centreService.searchCentres(name, adress).subscribe(
      (centre) => {
        if (centre) {
          console.log(`Nesto se desilo`);
          //this.centres = [centre];
          this.filteredCenters = [centre];
        } else {
          //this.centres = [];
          this.filteredCenters = [];
        }
      },
      (error: HttpErrorResponse) => {
        if (error.status === 404) {
          console.log(`No centre was found with the given name and address.`);
          this.centres = [];
        } else {
          console.log(`An error occurred: ${error.message}`);
        }
      }
    );
  }

  filterCenters(minAvgGrade: number) {
    this.filteredCenters = this.filteredCenters.filter(
      (centre) => centre.avgGrade >= minAvgGrade
    );
  }

  resetFilter() {
    this.filteredCenters = [...this.centres];
  }
}
