import { BloodType } from "../enums/BloodType";

export interface Report{
    
    bloodType:BloodType;
    napomenaDoktoruMedicine:string;
    bakarSulfat:string;
    nivo: string;
    hemoglobinometar:string;
    vrednost:string;
    pluca:string;
    srce:string;
    pritisak:string;
    razlogOdbijanja:string;
    pocetak: string;
    zavrsetak:string;
    mestoPunkcije:string;
    kolicinaKrvi:string;
    ostatak:string;
    zahtev:boolean;
}