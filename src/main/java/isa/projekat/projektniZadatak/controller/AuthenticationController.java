package isa.projekat.projektniZadatak.controller;


import isa.projekat.projektniZadatak.auth.LoginRequestDto;
import isa.projekat.projektniZadatak.auth.RefreshTokenRequestDto;
import isa.projekat.projektniZadatak.auth.RegistrationRequestDto;
import isa.projekat.projektniZadatak.model.Centre;
import isa.projekat.projektniZadatak.service.AuthenticationService;
import isa.projekat.projektniZadatak.service.CentreService;
import isa.projekat.projektniZadatak.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private CentreService centreService;

    @GetMapping("/all")
    public List<Centre> getCentres(){
        return centreService.getCentres();
    }


    @GetMapping("/searchCentre")
    public Centre searchCentre(@RequestParam("name") String name){
        return centreService.findCentreByName(name);

    }


    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody RegistrationRequestDto request) {
        try{

            return authenticationService.registerUser(request);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDto request) {
        try{
            return authenticationService.login(request);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//
//    @PostMapping("/refreshToken")
//    public ResponseEntity<?> refreshToken(@Valid @RequestBody RefreshTokenRequestDto refreshToken){
//        try{
//            return authenticationService.refreshToken(refreshToken.getRefreshToken());
//        }
//        catch (Exception e){
//            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/activate")
//    public ResponseEntity<?> activate(@RequestParam("token") UUID token){
//        try{
//            return authenticationService.activate(token);
//        }
//        catch (Exception e){
//            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/loginViaEmail/{email}")
//    public ResponseEntity<?> loginViaEmail(@PathVariable String email){
//        try{
//            return authenticationService.sendLoginTokenToEmail(email);
//        }
//        catch (Exception e){
//            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/login")
//    public ResponseEntity<?> loginViaToken(@RequestParam("token") UUID token)
//    {
//        try{
//            return authenticationService.loginViaToken(token);
//        }
//        catch (Exception e){
//            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
