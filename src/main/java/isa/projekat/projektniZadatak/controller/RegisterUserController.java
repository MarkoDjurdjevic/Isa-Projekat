package isa.projekat.projektniZadatak.controller;

import isa.projekat.projektniZadatak.model.RegisterUser;
import isa.projekat.projektniZadatak.service.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
