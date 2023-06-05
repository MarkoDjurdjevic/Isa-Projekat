package isa.projekat.projektniZadatak.model.dto;

import isa.projekat.projektniZadatak.model.Centre;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CentreDTO {

    private long id;

    private String name;

    private String address;

    private String description;

    private double avgGrade;

    private int rate;

}
