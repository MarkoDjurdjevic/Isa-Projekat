package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.model.Terms;
import isa.projekat.projektniZadatak.repository.TermsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TermsService {


    //pravi konstruktor klase termsrepositori kako bi se sve njegove metode mogle koristiti unutar service
    private final TermsRepository termsRepository;

    @Autowired
    public TermsService(TermsRepository termsRepository) {

        this.termsRepository = termsRepository;
    }


    public List<Terms> getAllTerms(){
        return termsRepository.findAll();
    }
    public void createTerms(Terms terms){
        termsRepository.save(terms);
    }
}
