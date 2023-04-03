package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.model.Terms;
import isa.projekat.projektniZadatak.model.Users;
import isa.projekat.projektniZadatak.repository.TermsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TermsService {


    //pravi konstruktor klase termsrepositori kako bi se sve njegove metode mogle koristiti unutar service
    private final TermsRepository termsRepository;
    private final UserService userService;

    @Autowired
    public TermsService(TermsRepository termsRepository,UserService userService) {

        this.termsRepository = termsRepository;
        this.userService = userService;
    }


    public List<Terms> getAllTerms(){
        return termsRepository.findAll();
    }

    public void createTerms(Terms terms1){
        
        List<Users>medicalUsers= userService.getMedicalUsers();
        Terms terms = new Terms();
        terms.setTime(terms1.getTime());
        terms.setDate(terms1.getDate());
        terms.setDuration(terms1.getDuration());
        terms.setMedicalUsers((ArrayList<Users>) medicalUsers);

        termsRepository.save(terms);
    }
}
