import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class FormDataService {
  dateInput: String;
  timeInput: string;

  updateDateAndTime(date: String, time: string) {
    this.dateInput = date;
    this.timeInput = time;
  }
}
