package isa.projekat.projektniZadatak.model.dto;

import isa.projekat.projektniZadatak.Enums.GenderEnum;
import isa.projekat.projektniZadatak.Enums.UserCategoryEnum;
import isa.projekat.projektniZadatak.Enums.UserRoleEnum;
import isa.projekat.projektniZadatak.model.Users;
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


    // private Long centreId;

    @Enumerated(EnumType.ORDINAL)
    private GenderEnum genderEnum;

    private UserRoleEnum userRoleEnum;

    public static UsersDTO toDTO(Users user) {
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setEmail(user.getEmail());
        usersDTO.setPassword(user.getPassword());
        usersDTO.setName(user.getName());
        usersDTO.setLastname(user.getLastname());
        usersDTO.setAdress(user.getAdress());
        usersDTO.setCity(user.getCity());
        usersDTO.setCountry(user.getCountry());
        usersDTO.setPhone(user.getPhone());
        usersDTO.setJMBG(user.getJmbg());
        usersDTO.setProfession(user.getProfession());
        usersDTO.setInformation(user.getInformation());
        usersDTO.setCategory(user.getCategory());
        usersDTO.setGenderEnum(user.getGenderEnum());
        usersDTO.setUserRoleEnum(user.getUserRoleEnum());

        return usersDTO;

    }
}


