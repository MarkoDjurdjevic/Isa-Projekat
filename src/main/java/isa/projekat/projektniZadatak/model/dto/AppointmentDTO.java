package isa.projekat.projektniZadatak.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class AppointmentDTO {

    private boolean available;
}
