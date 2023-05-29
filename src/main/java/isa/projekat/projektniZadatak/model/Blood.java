package isa.projekat.projektniZadatak.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import isa.projekat.projektniZadatak.Enums.BloodType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Blood {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable=false,updatable=false)
    private Long id;
    private BloodType bloodType;
    private String amount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "centre_id")
    @JsonBackReference
    private Centre centre;


}
