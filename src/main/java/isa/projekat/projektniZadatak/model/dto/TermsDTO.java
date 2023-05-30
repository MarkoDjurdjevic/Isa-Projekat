package isa.projekat.projektniZadatak.model.dto;

import isa.projekat.projektniZadatak.model.Terms;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class TermsDTO {

    private Long id;

    private String duration;
    private String date ;
    private String time;
    private Long userId;


}
