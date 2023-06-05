package isa.projekat.projektniZadatak.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table
public class Appointments {

  @Id
  @SequenceGenerator(name = "appointmentSeqGen", sequenceName = "appointmentSeqGen", initialValue = 1, allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "appointmentSeqGen")
  @Column(name="id", unique=true, nullable=false)
  private Long id;

  private LocalDate date;

  private String time;

  private int duration;

  private boolean available = true;

  private boolean present = true;

  @ManyToOne(fetch = FetchType.EAGER)
  private BloodType bloodType;

  @OneToOne
  @JsonIncludeProperties({"id", "name"})
  private RegisterUser registerUser;

  @ManyToOne(fetch = FetchType.EAGER)
  private Centre centre;


  @OneToOne
  @JsonIncludeProperties({"id", "name"})
  private Statement statement;



  @OneToMany(mappedBy = "appointments",fetch = FetchType.EAGER)
  @JsonIgnoreProperties("appointments")
  private List<Equipment> equipmentList;

//
//  private long cntrId;


}
