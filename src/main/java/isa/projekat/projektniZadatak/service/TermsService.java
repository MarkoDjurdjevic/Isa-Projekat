package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.model.*;
import isa.projekat.projektniZadatak.model.dto.TermsDTO;
import isa.projekat.projektniZadatak.repository.CentreAdminRepository;
import isa.projekat.projektniZadatak.repository.TermsRepository;
import isa.projekat.projektniZadatak.repository.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TermsService {


    //pravi konstruktor klase termsrepositori kako bi se sve njegove metode mogle koristiti unutar service
    private final UserAppService userService;
    private final SystemAdminRepository systemAdminRepository;

    @Autowired
    public TermsService(UserAppService userService,
                        UserAppRepository userRepository,
                        SystemAdminRepository systemAdminRepository,
                        CentreAdminRepository centreAdminRepository) {

        this.userService = userService;
        this.systemAdminRepository = systemAdminRepository;
        this.centreAdminRepository = centreAdminRepository;
    }
    @Autowired
    private UserAppRepository userAppRepository;
    @Autowired
    private TermsRepository termsRepository;
    private final CentreAdminRepository centreAdminRepository;


    public List<Terms> getAllTerms(){
        return termsRepository.findAll();
    }

    //videti sto mi se u bazi ne cuva?? sistem admin
    public void createTerms(TermsDTO termsDTO){

        UserApp loggedInUser = userAppRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());


//        System.out.println("systemAdminId: " + termsDTO.getSystemAdminId());
//        System.out.println("systemAdminOptional.isPresent(): " + systemAdminOptional.isPresent());

            Optional<CentreAdmin> systemAdminOptional = centreAdminRepository.findById(termsDTO.getSystemAdminId());
            CentreAdmin systemAdmin = systemAdminOptional.get();

            Terms terms = new Terms();
            terms.setDate(termsDTO.getDate());
            terms.setTime(termsDTO.getTime());
            terms.setReserve(false);
            terms.setDuration(termsDTO.getDuration());
            terms.setCentreAdmin(systemAdmin);

            termsRepository.save(terms);


    }

    public List<Terms>termsList(){
        List<Terms>termsList = termsRepository.findAll();
        List<Terms>termsFalse = new ArrayList<>();
        for (Terms terms:termsList){
            if (!terms.isReserve()){
                termsFalse.add(terms);
            }
        }
        return termsFalse;
    }

    //zauzimanje termina
    public void updateTerms(Long id) {

        Optional<Terms> termsOptional = termsRepository.findById(id);
        if (termsOptional.isPresent()) {
            Terms terms = termsOptional.get();
            if (!terms.isReserve()) {
                termsOptional.get().setReserve(true);
                termsRepository.save(termsOptional.get());

            }
        }
    }

    public void proveraTerms(Long id) {
        Optional<Terms> termsOptional = termsRepository.findById(id);
        if (termsOptional.isPresent()) {
            Terms terms = termsOptional.get();
            if (!terms.isReserve()) {
                terms.setReserve(true);
                termsRepository.save(terms);
            } else {
                // Termin je već zauzet
                System.out.println("Termin je već zauzet");
                throw new IllegalStateException("Termin je već zauzet");
            }
        } else {
            // Termin nije pronađen
            System.out.println("Termin nije pronađen");
            throw new NoSuchElementException("Termin nije pronađen");
        }
    }

}
