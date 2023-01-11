package isa.projekat.projektniZadatak.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateUsersDTO {


    private String password;
    private String name;
    private String lastname;
    private String adress;
    private String city;
    private String country;
    private String phone;
    private String profession;
    private String information;
    private String jmbg;
}
