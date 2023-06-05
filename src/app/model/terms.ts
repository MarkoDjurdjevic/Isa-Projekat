// import {Terms} from './terms';
import { User } from "./user"

export class Terms{
    id: number;
    date: string ;
    duration: string;
    reserve: boolean = false;
    time: string ; 
    systemAdminId: number;

  constructor(obj?: any) {
    if (obj) {
      this.id = obj.id;
      this.duration = obj.duration;
      this.date = obj.date;
      this.time = obj.time;
      this.reserve = obj.reserve;
      this.systemAdminId = obj.systemAdminId;
    }
  }
}

