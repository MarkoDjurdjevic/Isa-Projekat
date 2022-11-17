package isa.projekat.projektniZadatak.Enums;

public enum UserRoleEnum {
    UNREGISTERED_USER("UNREGISTERED_USER"),
    REGISTERED_USER("REGISTERED_USER"),
    SYSTEM_ADMINISTRATOR("SYSTEM_ADMINISTRATOR"),
    CENTRE_ADMINISTRATOR("CENTRE_ADMINISTRATOR");

    private final String user;

    UserRoleEnum(String user) {
        this.user = user;
    }
}
