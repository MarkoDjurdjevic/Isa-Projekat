package isa.projekat.projektniZadatak.model.dto;

import isa.projekat.projektniZadatak.Enums.BloodType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class AppointmentDTO {

    private long id;

    private LocalDate date;
    private String time;

    private int duration;
    private boolean available;


    //enum
    private BloodType bloodType;

    public AppointmentDTO(long id, LocalDate date, String time, int duration, boolean available, BloodType bloodType) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.available = available;
        this.bloodType = bloodType;
    }
}
