package isa.projekat.projektniZadatak.model.dto;

import isa.projekat.projektniZadatak.Enums.GenderEnum;
import isa.projekat.projektniZadatak.model.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@NoArgsConstructor
public class RegistrationDTO {


    private String email;

    private String password;

    private String name;

    private String lastname;

    private String adress;

    private String city;

    private String country;

    private String phone;

    private String jmbg;

    private String profession;

    private String information;

    @Enumerated(EnumType.ORDINAL)
    private GenderEnum genderEnum;


    public Users convertToUser(RegistrationDTO registrationDTO){
        Users users = new Users();
       users.setEmail((registrationDTO.getEmail()));
       users.setPassword(registrationDTO.getPassword());
       users.setName(registrationDTO.getName());
       users.setLastname(registrationDTO.getLastname());
       users.setAdress(registrationDTO.getAdress());
       users.setCity(registrationDTO.getCity());
       users.setCountry(registrationDTO.getCountry());
       users.setPhone(registrationDTO.getPhone());
       users.setJmbg(registrationDTO.getJmbg());
       users.setProfession(registrationDTO.getProfession());
       users.setInformation(registrationDTO.getInformation());
       users.setGenderEnum(registrationDTO.getGenderEnum());
        return users;
    }

}
