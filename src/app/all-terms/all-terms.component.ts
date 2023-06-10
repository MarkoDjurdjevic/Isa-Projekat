import { Component, OnInit } from '@angular/core';
import { Terms } from '../model/terms';
import { TermsService } from '../service/terms.service';

@Component({
  selector: 'app-all-terms',
  templateUrl: './all-terms.component.html',
  styleUrls: ['./all-terms.component.css']
})
export class AllTermsComponent implements OnInit {

  terms:Terms[];

  constructor(private termsService: TermsService) { }

  ngOnInit(): void {

    this.loadBusyTerms();
  }

  loadBusyTerms() {
    this.termsService.getBusyTerms().subscribe(
      users => {
        this.terms = users;
      },
      error => {
        console.log('Error occurred while fetching registered users:', error);
      }
    );
  }

}
