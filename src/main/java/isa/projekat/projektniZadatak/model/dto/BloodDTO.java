package isa.projekat.projektniZadatak.model.dto;

import isa.projekat.projektniZadatak.Enums.BloodType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BloodDTO {

    private Long id;
    private String amount;
    private BloodType bloodType;


}
