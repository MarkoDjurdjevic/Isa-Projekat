package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.model.Terms;
import isa.projekat.projektniZadatak.repository.TermsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TermsService {

    private final TermsRepository termsRepository;

    @Autowired
    public TermsService(TermsRepository termsRepository) {
        this.termsRepository = termsRepository;
    }

    public Terms createTerms(Terms terms){
        termsRepository.save(terms);
        return terms;
    }

    public List<Terms>getAllTerms(){
        return termsRepository.findAll();
    }
}
