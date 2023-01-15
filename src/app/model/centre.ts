import { Appointment } from './appointment';

export interface Centre {
  id: number;
  name: string;
  adress: string;
  description: string;
  avgGrade: number;
  //appointments: Appointment[];
  appointmentIds: number[];
}
