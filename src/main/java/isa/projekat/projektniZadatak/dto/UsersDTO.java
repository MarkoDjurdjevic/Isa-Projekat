package isa.projekat.projektniZadatak.dto;

import isa.projekat.projektniZadatak.Enums.GenderEnum;
import isa.projekat.projektniZadatak.Enums.UserCategoryEnum;
import isa.projekat.projektniZadatak.Enums.UserRoleEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Getter
@Setter
@NoArgsConstructor

public class UsersDTO {

    private Long id;

    private String email;

    private String password;

    private String name;

    private String lastname;

    private String adress;

    private String city;

    private String country;

    private String phone;

    private String JMBG;

    private String profession;

    private String information;

    private double points;

    private UserCategoryEnum category;


    private Long centreId;

    @Enumerated(EnumType.ORDINAL)
    private GenderEnum genderEnum;

    private UserRoleEnum userRoleEnum;
}
