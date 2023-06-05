import { Appointment } from './appointment';

export class Centre {
  name: string = '';
  address: string = '';
  description: string = '';
  avgGrade: number = 0;
  rate: number = 0;

  constructor(obj?: any) {
    if (obj) {

      this.name = obj.name;
      this.address = obj.address;
      this.description = obj.description;
      this.avgGrade = obj.avgGrade;
      this.rate = obj.rate;
    }
  }
}
