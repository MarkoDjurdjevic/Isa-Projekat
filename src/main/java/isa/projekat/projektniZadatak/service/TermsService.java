package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.Enums.UserRoleEnum;
import isa.projekat.projektniZadatak.model.Terms;
import isa.projekat.projektniZadatak.model.Users;
import isa.projekat.projektniZadatak.model.dto.TermsDTO;
import isa.projekat.projektniZadatak.model.dto.UsersDTO;
import isa.projekat.projektniZadatak.repository.TermsRepository;
import isa.projekat.projektniZadatak.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TermsService {


    //pravi konstruktor klase termsrepositori kako bi se sve njegove metode mogle koristiti unutar service
    private final TermsRepository termsRepository;
    private final UserService userService;

    @Autowired
    public TermsService(TermsRepository termsRepository,UserService userService,
                        UserRepository userRepository) {

        this.termsRepository = termsRepository;
        this.userService = userService;
    }


    public List<Terms> getAllTerms(){
        return termsRepository.findAll();
    }

    public void createTerms(TermsDTO termsDTO){

        Terms terms = new Terms();
        terms.setId(termsDTO.getId());
        terms.setDate(termsDTO.getDate());
        terms.setTime(termsDTO.getTime());
        terms.setDuration(termsDTO.getDuration());
        List<Users> users = userService.getCentreAdministartor();
        for (Users centreAdmin : users) {
//            if (centreAdmin.getId().equals(termsDTO.getUsers().getId()))
//              if(termsDTO.getUsers().getId().equals(centreAdmin.getId())){
                terms.setUsers(centreAdmin);
                break;
//            }
        }

        termsRepository.save(terms);

    }
}
