package isa.projekat.projektniZadatak.controller;

import isa.projekat.projektniZadatak.auth.RegistrationRequestDto;
import isa.projekat.projektniZadatak.model.UserApp;
import isa.projekat.projektniZadatak.model.dto.CentreDTO;
import isa.projekat.projektniZadatak.service.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path ="/userapp")
@CrossOrigin(origins= "http://localhost:4200/")
public class UserAppController {

    @Autowired
    private UserAppService userAppService;


    @PutMapping("/update")
    @PreAuthorize("hasAnyAuthority('CENTRE_ADMINISTRATOR')")
    public void updateCentre(@RequestBody RegistrationRequestDto registrationRequestDto){
        userAppService.update(registrationRequestDto);
        ResponseEntity.status(HttpStatus.OK);

    }

}
