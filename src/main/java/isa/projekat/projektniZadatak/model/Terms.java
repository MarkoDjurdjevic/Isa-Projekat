package isa.projekat.projektniZadatak.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import isa.projekat.projektniZadatak.model.dto.UsersDTO;
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
public class Terms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String date;
    private String time;
    private String duration;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Users users;

    public Terms(Long id, String date, String time, String duration, Users users) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.users = users;
    }

    @Override
    public String toString() {
        return "Terms{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", duration=" + duration +
                ",users = " + users +

                '}';
    }
}
