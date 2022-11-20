package isa.projekat.projektniZadatak.controller;

import isa.projekat.projektniZadatak.model.Users;
import isa.projekat.projektniZadatak.model.dto.RegistrationDTO;
import isa.projekat.projektniZadatak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/users")
public class UserController {
    private  final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/all")
    public List<Users> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/add")
    public void addUser(@RequestBody Users users){
        userService.addNewUser(users);
    }

    @DeleteMapping(path="/delete/{userId}")
    public void deleteUser(@PathVariable("userId")Long userId){
        userService.deleteUser(userId);
    }

    @PutMapping(path="/update/{userId}")
    public void updateUser(@PathVariable("userId")Long userId,@RequestParam(required=false)String name,
                         @RequestParam(required=false)String email,
                         @RequestParam(required=false)String adress,
                         @RequestParam(required=false)String city,
                         @RequestParam(required=false)String country,
                         @RequestParam(required=false)String phone,
                         @RequestParam(required=false)String information
                         ){
        userService.updateUser(userId,name,email,adress,city,country,phone,information);
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrationDTO registrationDTO){
        Users users = userService.register(registrationDTO);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/search/name")
    public List<Users> getUsers(@RequestParam String name, @RequestParam String lastname){
        return userService.getUsersByName(name, lastname);

    }
}
