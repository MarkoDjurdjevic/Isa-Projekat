import { BloodType } from "../enums/BloodType";

export interface Statement{

    bloodType:BloodType;
    napomena:string;
    bakarSulfat:string;
    hemoglobinometar:string;
    srce:string;
    pluca:string;
    krvniPritisak:string;
    zahtev:boolean;
    napomenaPregleda:string;
    razlogOdbijanja:string;
    mestoPunkcije:string;
    kolicinaUzeteKrvi:string;
    pocetakKrvi:string;
    krajKrvi:string;
    medicinskiRadnikId:number;




}