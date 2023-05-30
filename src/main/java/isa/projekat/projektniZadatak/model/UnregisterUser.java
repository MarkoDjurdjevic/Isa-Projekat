package isa.projekat.projektniZadatak.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UnregisterUser extends UserApp{

    public UnregisterUser(UserApp userApp) {
        super(userApp.getId(), userApp.getUsername(), userApp.getEmail(), userApp.getPassword(), userApp.getPasswordSalt(), userApp.getAddress(), userApp.getActive(), userApp.getRole(), userApp.getJMBG(), userApp.getName(), userApp.getLastname(), userApp.getPhoneNumber(), userApp.getGender());
    }
}
