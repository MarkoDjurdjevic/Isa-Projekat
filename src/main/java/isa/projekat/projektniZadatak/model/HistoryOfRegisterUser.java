package isa.projekat.projektniZadatak.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoryOfRegisterUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private long id;

    @OneToMany(mappedBy = "historyOfRegisterUser")
    @JsonIgnore
    private List<Equipment> equipmentList;

    @OneToOne
    @JsonIncludeProperties({"id", "name"})
    private Statement statement;

    @OneToOne
    @JsonIncludeProperties({"id", "name"})
    private RegisterUser registerUser;

}
