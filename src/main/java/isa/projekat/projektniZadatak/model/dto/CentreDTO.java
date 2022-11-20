package isa.projekat.projektniZadatak.model.dto;

import isa.projekat.projektniZadatak.model.Centre;
import isa.projekat.projektniZadatak.model.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CentreDTO {

    private long id;

    private String name;

    private String adress;

    private String description;

    private double avgGrade;

    public Centre convertToCentre(CentreDTO centreDTO){
        Centre centre = new Centre();
        centre.setId(centreDTO.getId());
        centre.setName(centreDTO.getName());
        centre.setAdress(centreDTO.getAdress());
        centre.setDescription(centreDTO.getDescription());
        centre.setAvgGrade(centreDTO.getAvgGrade());
        return centre;
    }
}
