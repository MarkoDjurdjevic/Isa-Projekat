package isa.projekat.projektniZadatak.service;


import isa.projekat.projektniZadatak.Enums.GenderEnum;
import isa.projekat.projektniZadatak.auth.LoginRequestDto;
import isa.projekat.projektniZadatak.auth.RegistrationRequestDto;
import isa.projekat.projektniZadatak.auth.UserTokenState;
import isa.projekat.projektniZadatak.model.*;
import isa.projekat.projektniZadatak.repository.GenderRepository;
import isa.projekat.projektniZadatak.repository.RoleRepository;
import isa.projekat.projektniZadatak.repository.UserAppRepository;
import isa.projekat.projektniZadatak.security.HashingAlogorithm;
import isa.projekat.projektniZadatak.security.TokenBasedAuthentication;
import isa.projekat.projektniZadatak.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthenticationService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserAppService userAppService;
    @Autowired
    private UserAppRepository userAppRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TokenUtils tokenUtils;
    @Autowired
    private ActivationTokenService activationTokenService;
    @Autowired
    private LoginTokenService loginTokenService;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private RefreshTokenService refreshTokenService;
    @Autowired
    private GenderRepository genderRepository;

    public ResponseEntity<?> registerUser(RegistrationRequestDto registrationRequest){
        try{
            if(userAppService.userExistsByUsernameOrEmail(registrationRequest.getUsername(), registrationRequest.getEmail())){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("A user with that username or email already exists.");
            }
            Role role = roleRepository.findByName(registrationRequest.getRoleName());
            if(role == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Invalid role name.");
            }
            Gender gender = genderRepository.findByName(registrationRequest.getGenderName());
            if(gender == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Invalid gender name.");
            }
            String passwordSalt = HashingAlogorithm.generateSalt();
            UserApp userToRegister = UserApp.builder()
                    .email(registrationRequest.getEmail())
                    .username(registrationRequest.getUsername())
                    .password(passwordEncoder.encode(registrationRequest.getPassword() + passwordSalt))
                    .passwordSalt(passwordSalt)
                    .role(role)
                    .address(registrationRequest.getAddress())
                    .JMBG(registrationRequest.getJMBG())
                    .name(registrationRequest.getName())
                    .lastname(registrationRequest.getLastname())
                    .phoneNumber(registrationRequest.getPhoneNumber())
                    .gender(gender)
                    .active(false)
                    .build();
            switch (role.getName()){
                case "SYSTEM_ADMINISTRATOR":
                    System.out.println("aaaaaaaaa");
                    userAppService.save(new SystemAdmin(userToRegister));
                    break;
                case "REGISTERED_USER":
                    userAppService.save(new RegisterUser(userToRegister));
                    break;
                case "CENTRE_ADMINISTRATOR":
                    userAppService.save(new CentreAdmin(userToRegister));
                    break;
                case "UNREGISTERED_USER":
                    userAppService.save(new UnregisterUser(userToRegister));
                    break;
                default:
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body("Invalid role name.");
            }
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred during registration.");
        }
    }

    public ResponseEntity<?> login(LoginRequestDto loginRequestDto){
        // Ukoliko kredencijali nisu ispravni, logovanje nece biti uspesno, desice se AuthenticationException
        try{
            String attemptedLoginPasswordSalt = "";
            UserApp attemptedLoginUser = userAppRepository.findByEmail(loginRequestDto.getEmail());
            if(attemptedLoginUser != null){
                attemptedLoginPasswordSalt = attemptedLoginUser.getPasswordSalt();
            }
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginRequestDto.getEmail(), loginRequestDto.getPassword() + attemptedLoginPasswordSalt));
            // Ukoliko je autentifikacija uspesna, ubaci korisnika u trenutni security kontekst
            SecurityContextHolder.getContext().setAuthentication(authentication);
            // Kreiraj token za tog korisnika
            UserApp user = (UserApp) authentication.getPrincipal();
            String jwt = tokenUtils.generateToken(user.getEmail(), user.getRole().getName());
            int expiresIn = tokenUtils.getExpiredIn();
            UUID refreshToken = refreshTokenService.generateRefreshToken(user);
            // Vrati token kao odgovor na uspesnu autentifikaciju
            return ResponseEntity.ok(new UserTokenState(jwt, refreshToken.toString(), expiresIn));
        }catch (AuthenticationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Bad credentials.");
        }
    }

    public ResponseEntity<?> refreshToken(UUID refreshToken){
        try{
            UserApp userToLogin = refreshTokenService.validateTokenAndGetUser(refreshToken);
            if(userToLogin == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Token is not valid.");
            }
            UserDetails userDetails = userDetailsService.loadUserByUsername(userToLogin.getUsername());
            TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetails);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserApp user = (UserApp) authentication.getPrincipal();
            String jwt = tokenUtils.generateToken(user.getUsername(), user.getRole().getName());
            int expiresIn = tokenUtils.getExpiredIn();
            return ResponseEntity.ok(new UserTokenState(jwt, refreshToken.toString(), expiresIn));
        }catch (AuthenticationException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while creating new access token.");
        }
    }

    public ResponseEntity<?> sendLoginTokenToEmail(String email){
        try{
            UserApp userApp = userAppRepository.findByEmail(email);
            if(userApp == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("User with does not exist with email: " + email);
            }
            if(!userApp.getActive()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Account with this email is not active.");
            }
            UUID loginToken = loginTokenService.generateLoginToken(userApp);
            //TODO send this token via email
            //String loginLink = "https://localhost:8081/auth/login?token="+loginToken;
            String frontendPageRedirection = "http://localhost:4200/login/" + loginToken;
            return ResponseEntity.status(HttpStatus.OK)
                    .body(frontendPageRedirection);
        }catch (AuthenticationException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while trying to send a token for login.");
        }
    }

    public String sendVerificationEmail(UserApp userApp){
        UUID verificationToken = activationTokenService.generateActivationToken(userApp);
        //TODO send this token via email
        return "http://localhost:8081/auth/activate?token="+verificationToken;
    }

    public ResponseEntity<?> activate(UUID token){
        try{
            return activationTokenService.activate(token);
        }catch (AuthenticationException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred during activation of account.");
        }
    }

    public ResponseEntity<?> loginViaToken(UUID token){
        try{
            UserApp userToLogin = loginTokenService.validateTokenAndGetUser(token);
            if(userToLogin == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Token is not valid.");
            }
            UserDetails userDetails = userDetailsService.loadUserByUsername(userToLogin.getUsername());
            TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetails);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserApp user = (UserApp) authentication.getPrincipal();
            String jwt = tokenUtils.generateToken(user.getUsername(), user.getRole().getName());
            int expiresIn = tokenUtils.getExpiredIn();
            UUID refreshToken = refreshTokenService.generateRefreshToken(user);
            return ResponseEntity.ok(new UserTokenState(jwt, refreshToken.toString(), expiresIn));
        }catch (AuthenticationException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred during login via token.");
        }
    }
}
