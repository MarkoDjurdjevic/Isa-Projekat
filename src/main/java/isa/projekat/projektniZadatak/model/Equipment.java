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
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String nameEquipment;

    private String quantitiofEquipment;

    @ManyToOne
    @JsonIncludeProperties({"id"})
    private Appointments appointments;

    @ManyToOne
    @JsonIncludeProperties({"id"})
    private HistoryOfRegisterUser historyOfRegisterUser;



}



