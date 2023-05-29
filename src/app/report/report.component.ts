import { Component, OnInit } from '@angular/core';
import { ReportService } from '../service/report.service';
import { FormBuilder, FormGroup, NgForm } from '@angular/forms';
import { HttpClient,HttpErrorResponse,  HttpClientModule } from '@angular/common/http'; // importujemo HttpClient
import { BloodType } from '../enums/BloodType';
import { Report } from '../model/report';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {
  subscribe:Subscription;
  response: Response;
  bloodTypes = Object.values(BloodType);
  zahtev: boolean = false;
  report:Report;

  constructor(private reportService: ReportService,
    private formBuilder:FormBuilder,
    private http: HttpClient,) { }

  ngOnInit(): void {
  }

  addReport(form:NgForm){
    const report = form.value;
    this.reportService.addReport(report).subscribe((response)=>{
    location.reload();
    }
    )
  }




}
