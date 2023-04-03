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
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable=false,updatable=false)
    private Long id;
    private String nameEquipment;
    private String quantitiofEquipment;

//    @ManyToOne
//    @JoinColumn(name = "report")
//    private Report report;

    @ManyToOne
    @JoinColumn(name = "appointments_id")
    private Appointments appointments;
//
//    @ManyToOne
//    @JoinColumn(name = "history_of_visitors_id")
//    private HistoryOfVisitors historyOfVisitors;


    public Equipment(Long id, String nameEquipment, String quantitiofEquipment, Appointments appointments) {
        this.id = id;
        this.nameEquipment = nameEquipment;
        this.quantitiofEquipment = quantitiofEquipment;
        this.appointments = appointments;
       // this.historyOfVisitors = historyOfVisitors;
    }
}
