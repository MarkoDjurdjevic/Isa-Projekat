import { Component, OnInit } from '@angular/core';
import { Blood } from '../model/blood';
import { Subscription } from 'rxjs';
import { HttpClient,HttpErrorResponse,  HttpClientModule } from '@angular/common/http'; // importujemo HttpClient
import { BloodService } from '../service/blood.service';
import { FormBuilder, FormGroup, NgForm } from '@angular/forms';
import { BloodType } from '../enums/BloodType';

@Component({
  selector: 'app-blood',
  templateUrl: './blood.component.html',
  styleUrls: ['./blood.component.css']
})
export class BloodComponent implements OnInit {

  bloods: Blood[];
  subscribe:Subscription;
  response : Response;
  blood:Blood;
  addingBlood=false;
  bloodTypes = Object.values(BloodType);
  filteredBlood : Blood[];
  _filterText: string = '';

  get filterText(){
    return this._filterText;
  }

  set filterText(value: string){
    this._filterText = value;
    this.filteredBlood = this.filterBloodByType(value);
    console.log(this.filterText);

  }

  constructor(private http: HttpClient,
    private bloodService: BloodService,
    private formBuilder:FormBuilder,) { }

  ngOnInit(): void {
    this.bloodService.getAllBlood().subscribe((response : Blood[])=>{
      this.bloods = response;
      this.filteredBlood = this.bloods;
    });
    
  }

  addBlood(form: NgForm){
      const blood= form.value;
      this.bloodService.addBlood(blood).subscribe((response)=>{
        location.reload();
      });
  }

  openFormBlood(){
    this.addingBlood = true;
  }

  filterBloodByType(filterTerm: string){
    if(this.bloods.length === 0 || this.filterText === ''){
      console.log("ovo radi 1");
      return this.bloods;
     
    }else{
      return this.bloods.filter((blood)=>
      {
        console.log("ovo radi 2");

        return blood.bloodType.toUpperCase() === filterTerm.toUpperCase();
      });
    }
  }
  

}
