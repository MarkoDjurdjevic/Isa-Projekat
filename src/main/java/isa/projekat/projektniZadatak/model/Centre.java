package isa.projekat.projektniZadatak.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
@AllArgsConstructor
public class Centre {
    @Id
    @SequenceGenerator(name = "centreSeqGen", sequenceName = "centreSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "centreSeqGen")
    @Column(name="id", unique=true, nullable=false)
    private long id;

    private String name;
    private String adress;
    private String description;

    private double avgGrade;


    private int rate;

//    @OneToMany
//    @JsonIgnore
//    @JoinColumn(name = "centre")
//    @JsonIgnoreProperties("centre")
//    private List<Appointments> appointments;

    @OneToMany(mappedBy = "centre")
    @JsonIgnore
    private List<RegisterUser>registerUsers;


    @OneToMany(mappedBy = "centre", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("centre")
    private List<CentreAdmin>centreAdmins;


    @OneToMany(mappedBy = "centre")
    @JsonIgnore
    private List<RateForCenter>rateForCenters;

//    @OneToMany(mappedBy = "centre")
//    @JsonIgnore
//    private List<RegisterUser>registerUser;



}
