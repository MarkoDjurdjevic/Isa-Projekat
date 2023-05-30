package isa.projekat.projektniZadatak.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequestDto {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String roleName;
    @NotBlank
    private String address;
    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    @NotBlank
    private String JMBG;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String genderName;

}