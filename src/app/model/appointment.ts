import { BloodType } from '../enums/BloodType';
import { Centre } from './centre';

export class Appointment {
  id:number =0;
  date: string;
  time: string ='';
  duration: number = 0;
  available: boolean = true;
  present: boolean = true;

  constructor(obj?: any) {
    if (obj) {
      this.date = obj.date;
      this.time = obj.time;
      this.duration = obj.duration;
      this.available = obj.available;
      this.present = obj.present;

    }
  }
}
