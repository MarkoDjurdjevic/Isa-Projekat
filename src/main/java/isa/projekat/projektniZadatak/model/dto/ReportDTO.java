package isa.projekat.projektniZadatak.model.dto;

import isa.projekat.projektniZadatak.Enums.BloodType;
import isa.projekat.projektniZadatak.model.Appointments;
import isa.projekat.projektniZadatak.model.Equipment;
import isa.projekat.projektniZadatak.model.Report;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ReportDTO {

    private Long id;
    @Enumerated(EnumType.ORDINAL)
    private BloodType bloodType;

    private String napomenaDoktoruMedicine;
    private String bakarSulfat, nivo;
    private String hemoglobinometar,vrednost;
    private String pluca,srce,pritisak;
    //zahtev odbijen/prihvacen
   // private boolean zahtev;
    private String razlogOdbijanja;
    private String pocetak;
    private String zavrsetak;
    private String mestoPunkcije;
    private String kolicinaKrvi;
    private String ostatak;


    public ReportDTO(Long id, BloodType bloodType, String napomenaDoktoruMedicine, String bakarSulfat, String nivo, String hemoglobinometar, String vrednost, String pluca, String srce, String pritisak, boolean zahtev, String razlogOdbijanja, String pocetak, String zavrsetak, String mestoPunkcije, String kolicinaKrvi, String ostatak, Equipment equipment) {
        this.id = id;
        this.bloodType = bloodType;
        this.napomenaDoktoruMedicine = napomenaDoktoruMedicine;
        this.bakarSulfat = bakarSulfat;
        this.nivo = nivo;
        this.hemoglobinometar = hemoglobinometar;
        this.vrednost = vrednost;
        this.pluca = pluca;
        this.srce = srce;
        this.pritisak = pritisak;
        //this.zahtev = zahtev;
        this.razlogOdbijanja = razlogOdbijanja;
        this.pocetak = pocetak;
        this.zavrsetak = zavrsetak;
        this.mestoPunkcije = mestoPunkcije;
        this.kolicinaKrvi = kolicinaKrvi;
        this.ostatak = ostatak;
       //  this.equipment = equipment;
    }

    public ReportDTO reportDTO(Report report){

        ReportDTO reportDTO = new ReportDTO();
//        report.setId(reportDTO.getId());
        reportDTO.setBloodType(report.getBloodType());
        reportDTO.setNapomenaDoktoruMedicine(report.getNapomenaDoktoruMedicine());
        reportDTO.setBakarSulfat(report.getBakarSulfat());
        reportDTO.setNivo(report.getNivo());
        reportDTO.setHemoglobinometar(report.getHemoglobinometar());
        reportDTO.setVrednost(report.getVrednost());
        reportDTO.setPluca(report.getPluca());
        reportDTO.setSrce(report.getSrce());
        reportDTO.setPritisak(report.getPritisak());
        //reportDTO.setZahtev(report.isZahtev());
        reportDTO.setRazlogOdbijanja(report.getRazlogOdbijanja());
        reportDTO.setPocetak(report.getPocetak());
        reportDTO.setZavrsetak(report.getZavrsetak());
        reportDTO.setMestoPunkcije(report.getMestoPunkcije());
        reportDTO.setKolicinaKrvi(report.getKolicinaKrvi());
        reportDTO.setOstatak(report.getOstatak());

        return  reportDTO;

    }


}
