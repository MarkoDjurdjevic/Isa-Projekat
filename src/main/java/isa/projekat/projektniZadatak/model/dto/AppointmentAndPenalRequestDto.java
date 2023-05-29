package isa.projekat.projektniZadatak.model.dto;

import isa.projekat.projektniZadatak.model.Appointments;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AppointmentAndPenalRequestDto {

    private Appointments appointments;
    private boolean available;
    private int penal;
}
