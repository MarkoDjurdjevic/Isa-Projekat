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

    @OneToMany
    @JoinColumn(name = "historyOfVisitors_id")
    private List<Statement>statementList;

    @OneToMany
    @JoinColumn(name = "historyOfVisitors_id")
    private List<Equipment>equipmentList;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;
}
