package isa.projekat.projektniZadatak.Enums;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


public enum GenderEnum {
    MALE("MALE"),
    FEMALE("FEMALE");
    private final String gender;


    GenderEnum(String gender) {
        this.gender = gender;
    }
}
