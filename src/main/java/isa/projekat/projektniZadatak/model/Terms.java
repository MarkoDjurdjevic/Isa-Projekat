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
public class Terms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String date;
    private String time;
    private String duration;
    @OneToMany(mappedBy = "medicalTerms")
    private List<MedicalUsers> medicalUsers;

    public Terms(Long id, String date, String time, String duration, List<MedicalUsers> medicalUsers) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.medicalUsers = medicalUsers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<MedicalUsers> getMedicalUsers() {
        return medicalUsers;
    }

    public void setMedicalUsers(ArrayList<MedicalUsers> medicalUsers) {
        this.medicalUsers = medicalUsers;
    }

    @Override
    public String toString() {
        return "Terms{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", duration=" + duration +
                "medicalUsers = " + medicalUsers +

                '}';
    }

}
