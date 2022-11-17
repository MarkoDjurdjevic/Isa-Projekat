package isa.projekat.projektniZadatak.model;

import isa.projekat.projektniZadatak.Enums.GenderEnum;
import isa.projekat.projektniZadatak.Enums.UserRoleEnum;

import javax.persistence.*;

@Entity
@Table
public class Users {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable=false,updatable=false)
    private Long id;

    private String name;
    private String email;
    private String address;
    private String city;
    private String country;
    private String phone;
    private String JMBG;
    private String information;

    @ManyToOne
    private Centre centre;

    @Enumerated(EnumType.ORDINAL)
    private GenderEnum genderEnum;


   private UserRoleEnum userRoleEnum;

    public Users() {
    }
//
//    public Users(Long id, String name, String email, String address, String city, String country, String phone, String JMBG, String information, GenderEnum genderEnum, UserRoleEnum userRoleEnum) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.address = address;
//        this.city = city;
//        this.country = country;
//        this.phone = phone;
//        this.JMBG = JMBG;
//        this.information = information;
//        this.genderEnum = genderEnum;
//        this.userRoleEnum = userRoleEnum;
//    }

    public Users(Long id, String name, String email, String address, String city, String country, String phone, String JMBG, String information, Centre centre, GenderEnum genderEnum, UserRoleEnum userRoleEnum) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.JMBG = JMBG;
        this.information = information;
        this.centre = centre;
        this.genderEnum = genderEnum;
        this.userRoleEnum = userRoleEnum;
    }

    public UserRoleEnum getUserRoleEnum() {
        return userRoleEnum;
    }

    public void setUserRoleEnum(UserRoleEnum userRoleEnum) {
        this.userRoleEnum = userRoleEnum;
    }

    public GenderEnum getGenderEnum() {
        return genderEnum;
    }

    public void setGenderEnum(GenderEnum genderEnum) {
        this.genderEnum = genderEnum;
    }


    public Centre getCentre() {
        return centre;
    }

    public void setCentre(Centre centre) {
        this.centre = centre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
