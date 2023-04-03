package isa.projekat.projektniZadatak.model;

import isa.projekat.projektniZadatak.Enums.BloodType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table
public class Appointments {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, updatable = false)
  private long id;

  private LocalDate date;
  private String time;

  private int duration;
  private boolean available;


  //enum
  private BloodType bloodType;

  @JsonIgnore
  //@JoinColumn(name = "centre_id") //za biderekcionu
  @ManyToOne
  private Centre centreAppointment;

  private long centreId;

  @OneToOne(mappedBy = "appointments")
  @JsonIgnore
  private Report report;

  @OneToMany(mappedBy = "appointments", cascade = CascadeType.ALL)
  private List<Equipment> equipment = new ArrayList<>();

  public Appointments(long id, LocalDate date, String time, int duration, boolean available, BloodType bloodType, Centre centreAppointment, long centreId, Report report,List<Equipment>  equipment) {
    this.id = id;
    this.date = date;
    this.time = time;
    this.duration = duration;
    this.available = available;
    this.bloodType = bloodType;
    this.centreAppointment = centreAppointment;
    this.centreId = centreId;
    this.report = report;
    this.equipment = equipment;
  }
}
