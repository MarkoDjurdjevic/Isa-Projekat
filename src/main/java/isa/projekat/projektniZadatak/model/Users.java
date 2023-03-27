package isa.projekat.projektniZadatak.model;

import isa.projekat.projektniZadatak.Enums.GenderEnum;
import isa.projekat.projektniZadatak.Enums.UserCategoryEnum;
import isa.projekat.projektniZadatak.Enums.UserRoleEnum;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
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

    //private double points;

    private UserCategoryEnum category;

    @ManyToOne
    @JoinColumn(name = "center_id")
    private Centre centre;

    @Enumerated(EnumType.ORDINAL)
    private GenderEnum genderEnum;

  @Enumerated(EnumType.ORDINAL) //dodao ovo sa securitijem
   private UserRoleEnum userRoleEnum;

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
}
