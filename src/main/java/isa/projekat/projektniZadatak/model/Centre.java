package isa.projekat.projektniZadatak.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
@ToString
@AllArgsConstructor
public class Centre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;

    private String name;
    private String adress;
    private String description;

    private double avgGrade;

    private int rate;

    @OneToMany(mappedBy = "centreAppointment")
    private List<Appointments> appointments;

    @OneToMany
    @JoinColumn(name = "centre_id")
    @JsonManagedReference
    private List<Blood>blood;

//    @OneToOne
//    @JoinColumn(name = "centre_id")
//    private CentreForRate centreForRate;

}
