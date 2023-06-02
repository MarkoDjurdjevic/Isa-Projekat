package isa.projekat.projektniZadatak.model.dto;

import isa.projekat.projektniZadatak.model.Terms;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TermsDTO {

    private String duration;
    private String date ;
    private String time;
    private boolean reserve;
    private Long systemAdminId;


}
