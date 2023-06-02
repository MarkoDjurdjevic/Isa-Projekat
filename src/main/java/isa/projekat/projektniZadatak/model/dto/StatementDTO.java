package isa.projekat.projektniZadatak.model.dto;

import isa.projekat.projektniZadatak.model.BloodType;
import isa.projekat.projektniZadatak.model.Statement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StatementDTO {

    private String bloodTypeName;

    private String napomena;

    private String bakarSulfat;

    private String hemoglobinometar;

    private String srce;

    private String pluca;

    private String krvniPritisak;

    private boolean zahtev;

    private String napomenaPregleda;

    private String razlogOdbijanja;

    private String mestoPunkcije;

    private String kolicinaUzeteKrvi;

    private String pocetakKrvi;

    private String krajKrvi;


}
