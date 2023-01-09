package isa.projekat.projektniZadatak.model;

import isa.projekat.projektniZadatak.Enums.GenderEnum;
import isa.projekat.projektniZadatak.Enums.UserCategoryEnum;
import isa.projekat.projektniZadatak.Enums.UserRoleEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table
public class Users {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable=false,updatable=false)
    private Long id;


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

    //private double points;

    private UserCategoryEnum category;

    @ManyToOne
    private Centre centre;

    @Enumerated(EnumType.ORDINAL)
    private GenderEnum genderEnum;


   private UserRoleEnum userRoleEnum;

}
