package isa.projekat.projektniZadatak.auth;

import isa.projekat.projektniZadatak.Enums.UserRoleEnum;
import isa.projekat.projektniZadatak.config.JwtService;
import isa.projekat.projektniZadatak.model.Users;
import isa.projekat.projektniZadatak.repository.CentreRepository;
import isa.projekat.projektniZadatak.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;



  private final JwtService jwtService;

  private final AuthenticationManager authenticationManager;
  public AuthenticationResponse register(RegisterRequest request) {
    var user = Users.builder()
      .name(request.getFirstname())
      .lastname(request.getLastname())
      .email(request.getEmail())
      .password(passwordEncoder.encode(request.getPassword()))
      //.userRoleEnum(Role.REGISTERED_USER)
      .build();
    repository.save(user);
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
      .token(jwtToken).build();
  }

  public AuthenticationResponse authenticate(AuthenticationReqeust request) {
    authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(
        request.getEmail(),
        request.getPassword()
      )
    );
    var user = repository.findByEmail(request.getEmail()).orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
      .token(jwtToken).build();
  }
}
