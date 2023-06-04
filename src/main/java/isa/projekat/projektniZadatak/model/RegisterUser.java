package isa.projekat.projektniZadatak.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RegisterUser extends UserApp{

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIncludeProperties({"id", "name"})
    private Centre centre;

    @OneToOne(mappedBy = "registerUser", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("registerUser")
    private Appointments appointments;

    @OneToOne(mappedBy = "registerUser", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("registerUser")
    private HistoryOfRegisterUser historyOfRegisterUser;
//
//    @OneToOne(mappedBy = "registerUser", fetch = FetchType.EAGER)
//    @JsonIgnoreProperties("registerUser")
//    private Centre centre;

    @OneToMany(mappedBy = "registerUser")
    @JsonIgnore
    private List<RateForCenter>rateForCenters;

    private int penal;

    public RegisterUser(UserApp userApp) {
        super(userApp.getId(), userApp.getUsername(), userApp.getEmail(), userApp.getPassword(), userApp.getPasswordSalt(), userApp.getAddress(), userApp.getActive(), userApp.getRole(), userApp.getJMBG(), userApp.getName(), userApp.getLastname(), userApp.getPhoneNumber(), userApp.getGender());
    }
}
