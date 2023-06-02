package isa.projekat.projektniZadatak.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
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
    @SequenceGenerator(name = "statementSeqGen", sequenceName = "statementSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "statementSeqGen")
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
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


    @OneToOne(mappedBy = "statement", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("statement")
    private Appointments appointments;

    @OneToOne(mappedBy = "statement", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("statement")
    private HistoryOfRegisterUser historyOfRegisterUser;



}
