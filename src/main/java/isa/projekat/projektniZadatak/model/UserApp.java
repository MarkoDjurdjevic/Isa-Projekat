package isa.projekat.projektniZadatak.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import isa.projekat.projektniZadatak.Enums.GenderEnum;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"accountNonExpired", "credentialsNonExpired", "accountNonLocked", "authorities"})
public class UserApp implements UserDetails {
    @Id
    @SequenceGenerator(name = "userAppSeqGen", sequenceName = "userAppSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "userAppSeqGen")
    @Column(name="id", unique=true, nullable=false)
    private long id;

    @Column(unique = true, nullable = false)
    @NotBlank
    private String username;

    @Column(unique = true, nullable = false)
    @NotBlank
    @Email
    private String email;

    @JsonIgnore
    @Column
    @NotBlank
    private String password;

    private String passwordSalt;

    @Column
    private String address;

    @Column
    private Boolean active = false;

    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;

    @Column
    private String JMBG;

    @Column
    private String name;

    @Column
    private String lastname;

    @Column
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    private Gender gender;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(this.role.getName()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
