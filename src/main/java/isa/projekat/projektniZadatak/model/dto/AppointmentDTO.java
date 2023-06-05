package isa.projekat.projektniZadatak.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Getter
@Setter
public class AppointmentDTO {

    private LocalDate date;
    private String time;
    private int duration;
    private Long centreId;
    private String bloodName;
    private boolean available;
    private boolean present;
}
