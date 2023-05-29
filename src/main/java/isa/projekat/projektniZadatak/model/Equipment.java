package isa.projekat.projektniZadatak.model;

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
    @JoinColumn(name = "appointments_id")
    private Appointments appointments;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Report report;



}



