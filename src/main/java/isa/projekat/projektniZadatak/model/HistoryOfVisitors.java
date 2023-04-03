package isa.projekat.projektniZadatak.model;

import isa.projekat.projektniZadatak.model.dto.EquipmentDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class HistoryOfVisitors {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable=false,updatable=false)
    private Long id;
//    @OneToMany
//    @JoinColumn(name = "historyOfVisitors")
//    private List<Report>reports;
//    @OneToMany
//    @JoinColumn(name = "historyOfVisitors")
//    private List<Equipment>equipment;

//    @ManyToOne
//    @JoinColumn(name = "equipment_id")
//    private Equipment equipment;


    public HistoryOfVisitors(Long id, List<Report> reports, List<Equipment> equipment) {
        this.id = id;
        //this.reports = reports;
       // this.equipment = equipment;
    }
}
