import { BloodType } from '../enums/BloodType';
import { Centre } from './centre';

export interface Appointment {
  //id: number;
  date: String;
  time: String;
  bloodType: BloodType;
  centreId: number;
}
