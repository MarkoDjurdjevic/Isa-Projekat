package isa.projekat.projektniZadatak.service;


import isa.projekat.projektniZadatak.auth.RegistrationRequestDto;
import isa.projekat.projektniZadatak.model.RegisterUser;
import isa.projekat.projektniZadatak.model.UserApp;
import isa.projekat.projektniZadatak.repository.RoleRepository;
import isa.projekat.projektniZadatak.repository.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAppService implements UserDetailsService {
    @Autowired
    private UserAppRepository userAppRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<?> getAllUsers(){
        List<UserApp> allUsers = userAppRepository.findAll();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    public ResponseEntity<?> getById(Long userId){
        UserApp userApp = userAppRepository.findById(userId).orElse(null);
        if(userApp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("User with id '" + userId + "' does not exist.");
        }
        if(!userApp.getActive()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("User with id '" + userId + "' is not active.");
        }
        return new ResponseEntity<>(userApp, HttpStatus.OK);
    }

    //update nesto zeza
    ///i skroz naopacke radi
    // pogledati jos malo
    public void update(RegistrationRequestDto registrationRequestDto){
        UserApp loggedInUser = userAppRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
//        Optional<UserApp>userAppOptional = userAppRepository.findById(loggedInUser.getId());
//        if(userAppOptional.isPresent()){
            loggedInUser.setUsername(registrationRequestDto.getUsername());
            loggedInUser.setEmail(registrationRequestDto.getEmail());
            loggedInUser.setPassword(registrationRequestDto.getPassword());
            loggedInUser.setPasswordSalt(registrationRequestDto.getPassword());
            loggedInUser.setJMBG(registrationRequestDto.getJMBG());
            loggedInUser.setName(registrationRequestDto.getName());
            loggedInUser.setLastname(registrationRequestDto.getLastname());
            loggedInUser.setPhoneNumber(registrationRequestDto.getPhoneNumber());

            userAppRepository.save(loggedInUser);
//        }

    }

    public UserApp save(UserApp userApp){
        return userAppRepository.save(userApp);
    }

    public boolean userExistsByUsernameOrEmail(String username, String email) {
        return userAppRepository.existsByUsernameOrEmail(username, email);
    }

    public ResponseEntity<?>  getMyInfo(){
        UserApp loggedInUser = userAppRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        return ResponseEntity.status(HttpStatus.OK).body(loggedInUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAppRepository.findByEmail(username);
    }

}

