import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class FormDataService {
  dateInput: String;
  timeInput: string;
  duration: number;

  updateDateAndTime(date: String, time: string) {
    this.dateInput = date;
    this.timeInput = time;
  }

  updateDateAndTimeAndDuration(date: String, time: string, duration: number) {
    this.dateInput = date;
    this.timeInput = time;
    this.duration = duration;
  }
}
