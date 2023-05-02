package isa.projekat.projektniZadatak.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor

@Entity
@Table
public class Centre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;

    private String name;
    private String adress;
    private String description;

    private double avgGrade;

    //spisak administratora centara
//    @OneToMany(mappedBy = "centre")
//    private List<Users> administrators;

    //slobodni termini za rezervisanje
    @OneToMany(mappedBy = "centreAppointment")
    private List<Appointments> appointments;

    @Override
    public String toString() {
        return "Centre{" +
                "id=" + id +
                ", adress='" + adress + '\'' +
                ", description='" + description + '\'' +
                ", avgGrade=" + avgGrade +
//                "Administators = " + administrators +
                "Appointments = " + appointments +
                '}';
    }


}
