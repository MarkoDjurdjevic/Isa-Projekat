package isa.projekat.projektniZadatak.controller;

import isa.projekat.projektniZadatak.model.Appointments;
import isa.projekat.projektniZadatak.model.CentreAdmin;
import isa.projekat.projektniZadatak.model.RegisterUser;
import isa.projekat.projektniZadatak.service.AdminCentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/adminCentre")
@CrossOrigin(origins= "http://localhost:4200/")
public class AdminCentreController {

    @Autowired
    private AdminCentreService adminCentreService;

    @GetMapping("/allAppointment")
    @PreAuthorize("hasAnyAuthority('CENTRE_ADMINISTRATOR')")
    public List<Appointments> allAppontment(){
        return adminCentreService.appointmentsList();
    }


    @GetMapping("/searchUser")
    @PreAuthorize("hasAnyAuthority('CENTRE_ADMINISTRATOR')")
    public RegisterUser searchUser(@RequestParam("name") String name, @RequestParam("lastname") String lastname) {
        return adminCentreService.searchRegisterUser(name, lastname);
    }

    @GetMapping("/getCentreAdmin")
    @PreAuthorize("hasAnyAuthority('CENTRE_ADMINISTRATOR')")
    public CentreAdmin getCentreAdmin() {
        return adminCentreService.centreAdmin();
    }

}
