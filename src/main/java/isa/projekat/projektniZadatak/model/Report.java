package isa.projekat.projektniZadatak.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import isa.projekat.projektniZadatak.Enums.BloodType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private BloodType bloodType;

    private String napomenaDoktoruMedicine;
    private String bakarSulfat, nivo;
    private String hemoglobinometar,vrednost;
    private String pluca,srce,pritisak;
    //zahtev odbijen/prihvacen
    private boolean zahtev;
    private String razlogOdbijanja;
    private String pocetak;
    private String zavrsetak;
    private String mestoPunkcije;
    private String kolicinaKrvi;
    private String ostatak;


    @OneToOne
    @JoinColumn(name = "appointments")
    @JsonIgnore
    private Appointments appointments;

//    @ManyToOne
//    @JoinColumn(name = "historyOfVisitors_id")
//    private HistoryOfVisitors historyOfVisitors;
//    @ManyToOne
//    @JoinColumn(name = "equipment_id")
//   private Equipment equipment;

    public Report(Long id, BloodType bloodType, String napomenaDoktoruMedicine, String bakarSulfat, String nivo, String hemoglobinometar, String vrednost, String pluca, String srce, String pritisak, boolean zahtev, String razlogOdbijanja, String pocetak, String zavrsetak, String mestoPunkcije, String kolicinaKrvi, String ostatak, Appointments appointments) {
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
        this.zahtev = zahtev;
        this.razlogOdbijanja = razlogOdbijanja;
        this.pocetak = pocetak;
        this.zavrsetak = zavrsetak;
        this.mestoPunkcije = mestoPunkcije;
        this.kolicinaKrvi = kolicinaKrvi;
        this.ostatak = ostatak;
        this.appointments = appointments;
        //this.equipment = equipment;
    }
}
