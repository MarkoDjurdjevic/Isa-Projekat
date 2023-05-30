package isa.projekat.projektniZadatak.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import isa.projekat.projektniZadatak.Enums.BloodType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Statement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

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

//    @ManyToOne
//    @JoinColumn(name = "historyOfVisitors_id")
//    private HistoryOfVisitors historyOfVisitors;

    @OneToOne
    @JoinColumn(name = "appointments_id")
    private Appointments appointments;

//    @ManyToOne
//    @JoinColumn(name = "users_id")
//    private Users administrator;
//
//
//    @ManyToOne
//    @JoinColumn(name = "statement_id")
//    private Report report;


}
