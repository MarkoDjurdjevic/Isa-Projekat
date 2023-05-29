package isa.projekat.projektniZadatak.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Report {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable=false,updatable=false)
    private Long id;

    @OneToMany
    @JoinColumn(name = "statement_id")
    private List<Statement> statement;

    @OneToMany
    @JoinColumn(name = "equipment_id")
    private List<Equipment> equipment;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;

}
