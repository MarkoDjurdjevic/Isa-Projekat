package isa.projekat.projektniZadatak.controller;

import isa.projekat.projektniZadatak.model.RegisterUser;
import isa.projekat.projektniZadatak.service.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/registerUser")
@CrossOrigin(origins= "http://localhost:4200/")
public class RegisterUserController {

    @Autowired
    private RegisterUserService registerUserService;

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('CENTRE_ADMINISTRATOR')")
    public List<RegisterUser>registerUserList(){
       return registerUserService.registerUserList();
    }

    @GetMapping("/allRegisterUser")
    @PreAuthorize("hasAnyAuthority('CENTRE_ADMINISTRATOR')")
    public List<RegisterUser>registerUserByAppointment(){
        return registerUserService.getAllRegisterUserByAppointment();
    }

    @GetMapping("/{id}/getUser")
    @PreAuthorize("hasAnyAuthority('CENTRE_ADMINISTRATOR')")
    public void getUserById(@PathVariable Long id){
        registerUserService.findRegisterUserById(id);
    }
}
