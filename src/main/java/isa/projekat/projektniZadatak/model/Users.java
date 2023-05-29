package isa.projekat.projektniZadatak.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import isa.projekat.projektniZadatak.Enums.GenderEnum;
import isa.projekat.projektniZadatak.Enums.UserCategoryEnum;
import isa.projekat.projektniZadatak.Enums.UserRoleEnum;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table
public class Users implements UserDetails {

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


    private UserCategoryEnum category;

    @Enumerated(EnumType.ORDINAL)
    private GenderEnum genderEnum;

    @Enumerated(EnumType.ORDINAL) //dodao ovo sa securitijem
    private UserRoleEnum userRoleEnum;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private List<Terms> terms;

    @OneToMany
    @JoinColumn(name = "users_id")
    private List<Statement> statements;

    @OneToMany
    @JoinColumn(name = "users_id")
    private List<HistoryOfVisitors> historyOfVisitorsList;

//    private int penal;


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(userRoleEnum.name()));
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
    return true;
  }

  @Override
  public String getPassword(){
    return password;
  }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password=" + password + '\''+
                ",lastname = " + lastname + '\''+
                ",adress = " + adress +'\''+
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", phone=" + phone + '\''+
                ",jmbg = " + jmbg + '\''+
                ",profession = " + profession +'\''+
                ", information=" + information + '\''+
                ",category = " + category + '\''+
                ",genderEnum = " + genderEnum +'\''+
                ", userRoleEnum='" + userRoleEnum + '\'' +
//                ", points=" + points + '\''+
                '}';
    }
}
