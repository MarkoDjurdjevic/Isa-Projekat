package isa.projekat.projektniZadatak.model.dto;

import isa.projekat.projektniZadatak.model.Terms;
import isa.projekat.projektniZadatak.model.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter

public class TermsDTO {

    private Long id;

    private String duration;
    private String date ;
    private String time;
    private Users users;

    public TermsDTO(Long id, String duration, String date, String time, Users users) {
        this.id = id;
        this.duration = duration;
        this.date = date;
        this.time = time;
        this.users = users;
    }

    public TermsDTO termsDTO(Terms terms){
       TermsDTO termsDTO = new TermsDTO();
       termsDTO.setId(terms.getId());
       termsDTO.setDate(terms.getDate());
       termsDTO.setTime(terms.getTime());
       termsDTO.setDuration(terms.getDuration());
       termsDTO.setUsers(terms.getUsers());
       return  termsDTO;
    }


}
