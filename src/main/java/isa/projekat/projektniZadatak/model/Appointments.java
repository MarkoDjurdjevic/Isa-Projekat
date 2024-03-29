package isa.projekat.projektniZadatak.model;

import isa.projekat.projektniZadatak.Enums.BloodType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

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
}
