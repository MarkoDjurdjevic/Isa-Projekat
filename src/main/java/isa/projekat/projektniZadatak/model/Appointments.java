package isa.projekat.projektniZadatak.model;

import isa.projekat.projektniZadatak.Enums.BloodType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
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

  //enum
  private BloodType bloodType;

  @ManyToOne
  private Centre centreAppointment;
}
