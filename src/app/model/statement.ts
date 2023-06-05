import { Appointment } from "./appointment";

export class Statement {
    bloodTypeName: any='';
    napomena: string = '';
    bakarSulfat: string = '';
    hemoglobinometar: string = '';
    srce: string = '';
    pluca: string = '';
    krvniPritisak: string = '';
    zahtev: boolean = false;
    napomenaPregleda: string = '';
    razlogOdbijanja: string = '';
    mestoPunkcije: string = '';
    kolicinaUzeteKrvi: string = '';
    pocetakKrvi: string = '';
    krajKrvi: string = '';
    appointmentId: number;
    // appointments: Appointment | null = null;
    // historyOfRegisterUser: HistoryOfRegisterUser | null = null;
  
    constructor(obj?: any) {
      if (obj) {

        this.bloodTypeName = obj.bloodTypeName;
        this.napomena = obj.napomena;
        this.bakarSulfat = obj.bakarSulfat;
        this.hemoglobinometar = obj.hemoglobinometar;
        this.srce = obj.srce;
        this.pluca = obj.pluca;
        this.krvniPritisak = obj.krvniPritisak;
        this.zahtev = obj.zahtev;
        this.napomenaPregleda = obj.napomenaPregleda;
        this.razlogOdbijanja = obj.razlogOdbijanja;
        this.mestoPunkcije = obj.mestoPunkcije;
        this.kolicinaUzeteKrvi = obj.kolicinaUzeteKrvi;
        this.pocetakKrvi = obj.pocetakKrvi;
        this.krajKrvi = obj.krajKrvi;
        this.appointmentId = obj.appointmentId;
        // this.appointments = obj.appointments;
        // this.historyOfRegisterUser = obj.historyOfRegisterUser;
      }
    }
  }