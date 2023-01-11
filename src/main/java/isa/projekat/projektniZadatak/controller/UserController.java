package isa.projekat.projektniZadatak.controller;

import isa.projekat.projektniZadatak.model.Users;
import isa.projekat.projektniZadatak.dto.RegistrationDTO;
import isa.projekat.projektniZadatak.dto.UpdateUsersDTO;
import isa.projekat.projektniZadatak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins= "http://localhost:4200/")
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

//    @GetMapping("/search/{name}")
//    public List<Users> getUsers(@PathVariable("name") String name){
//        return userService.getUsersByName(name);
//
//    }

    @GetMapping("/search/name")
    public List<Users> getUsers(@RequestParam String name, @RequestParam String lastname){
        return userService.getUsersByName(name, lastname);

    }


    @PostMapping("/add")
    public void addUser(@RequestBody Users users){
        userService.addNewUser(users);
    }

    @DeleteMapping(path="/delete/{userId}")
    public void deleteUser(@PathVariable("userId")Long userId){
        userService.deleteUser(userId);
    }

//    @PutMapping(path="/update/{userId}")
//    public void updateUser(@PathVariable("userId")Long userId,@RequestParam(required=false)String name,
//
//                           @RequestParam(required=false)String adress,
//                           @RequestParam(required=false)String city,
//                           @RequestParam(required=false)String country,
//                           @RequestParam(required=false)String phone,
//                           @RequestParam(required=false)String information
//    ){
//        userService.updateUser(userId,name,adress,city,country,phone,information);
//    }

    @PutMapping(path="/update/{userId}")
    public void updateUser(@PathVariable("userId") Long userId, @RequestBody UpdateUsersDTO updateUsersDTO) {
        userService.updateUser(userId, updateUsersDTO);
    }



    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrationDTO registrationDTO){
        Users users = userService.register(registrationDTO);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    //DODATO It is generally a good idea to use a GET request to retrieve a resource, and a POST request to create or update a resource. In this case, you're trying to log in a user, which could be considered an update to the user's login status. Therefore, it is appropriate to use a POST request for the login process.
    //
    //Using a POST request for the login process has some security benefits as well. With a POST request, you can include the login credentials in the request body, which is not visible in the URL. This makes it more difficult for an attacker to intercept the login request and get hold of the login credentials.
    //
    //That being said, you could use a GET request for the login process if you prefer. You could include the login credentials as query parameters in the URL (e.g., /users/login?email=<email>&password=<password>). However, this would expose the login credentials in the URL, which is not as secure as using a POST request with the credentials in the request body.
    @PostMapping("/login")
    public ResponseEntity<Users> login(@RequestBody Users users) {
        Users user = userService.login(users.getEmail(), users.getPassword());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(user);
    }
}
