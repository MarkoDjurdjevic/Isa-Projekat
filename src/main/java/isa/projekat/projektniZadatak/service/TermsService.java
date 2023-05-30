package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.model.Terms;
import isa.projekat.projektniZadatak.model.UserApp;
import isa.projekat.projektniZadatak.model.dto.TermsDTO;
import isa.projekat.projektniZadatak.repository.TermsRepository;
import isa.projekat.projektniZadatak.repository.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TermsService {


    //pravi konstruktor klase termsrepositori kako bi se sve njegove metode mogle koristiti unutar service
    private final TermsRepository termsRepository;
    private final UserAppService userService;

    @Autowired
    public TermsService(TermsRepository termsRepository, UserAppService userService,
                        UserAppRepository userRepository) {

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
//        List<UserApp> users = userService.getCentreAdministartor();
//        for (Users centreAdmin : users) {
////            if (centreAdmin.getId().equals(termsDTO.getUsers().getId()))
////              if(termsDTO.getUsers().getId().equals(centreAdmin.getId())){
//                terms.setUsers(centreAdmin);
//                break;
////            }
//        }

        termsRepository.save(terms);

    }
}
