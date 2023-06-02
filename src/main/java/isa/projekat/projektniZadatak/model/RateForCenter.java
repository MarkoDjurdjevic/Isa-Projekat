package isa.projekat.projektniZadatak.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAnyAttribute;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
@AllArgsConstructor
public class RateForCenter {

    @Id
    @SequenceGenerator(name = "centreSeqGen", sequenceName = "centreSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "centreSeqGen")
    @Column(name="id", unique=true, nullable=false)
    private long id;


    int rate;

    @ManyToOne
    private Centre centre;

    @ManyToOne
    private RegisterUser registerUser;
}
