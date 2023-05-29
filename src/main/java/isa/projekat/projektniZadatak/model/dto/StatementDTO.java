package isa.projekat.projektniZadatak.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import isa.projekat.projektniZadatak.Enums.BloodType;
import isa.projekat.projektniZadatak.model.Appointments;
import isa.projekat.projektniZadatak.model.Equipment;
import isa.projekat.projektniZadatak.model.Statement;
import isa.projekat.projektniZadatak.model.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class StatementDTO {

    private BloodType bloodType;

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

    private StatementDTO statementDTO(Statement statement){
        StatementDTO statementDTO = new StatementDTO();
        statementDTO.setBloodType(statement.getBloodType());
        statementDTO.setNapomena(statement.getNapomena());
        statementDTO.setBakarSulfat(statement.getBakarSulfat());
        statementDTO.setHemoglobinometar(statement.getHemoglobinometar());
        statementDTO.setSrce(statement.getSrce());
        statementDTO.setPluca(statement.getPluca());
        statementDTO.setKrvniPritisak(statement.getKrvniPritisak());
        statementDTO.setZahtev(statement.isZahtev());
        statementDTO.setNapomenaPregleda(statement.getNapomenaPregleda());
        statementDTO.setRazlogOdbijanja(statement.getRazlogOdbijanja());
        statementDTO.setMestoPunkcije(statement.getMestoPunkcije());
        statementDTO.setKolicinaUzeteKrvi(statement.getKolicinaUzeteKrvi());
        statementDTO.setPocetakKrvi(statement.getPocetakKrvi());
        statementDTO.setKrajKrvi(statement.getKrajKrvi());
        return statementDTO;
    }

}
