package isa.projekat.projektniZadatak.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
@AllArgsConstructor
public class Terms {
    @Id
    @SequenceGenerator(name = "termsSeqGen", sequenceName = "termsSeqGen", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "termsSeqGen")
    @Column(name="id", unique=true, nullable=false)
    private Long id;
    private String date;
    private String time;
    private String duration;
    private boolean reserve = false;

    @ManyToOne
    @JsonIncludeProperties({"id"})
    private CentreAdmin centreAdmin;

}
