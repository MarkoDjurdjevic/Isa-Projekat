package isa.projekat.projektniZadatak.controller;

import isa.projekat.projektniZadatak.model.Centre;
import isa.projekat.projektniZadatak.model.Terms;
import isa.projekat.projektniZadatak.repository.TermsRepository;
import isa.projekat.projektniZadatak.service.TermsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path ="/terms")
public class TermsController {

    private final TermsService termsService;


    public TermsController(TermsService termsService) {
        this.termsService = termsService;
    }

    @PostMapping("/add")
    public ResponseEntity<Terms> registerNewTerms(@RequestBody Terms terms){
        Terms newTerms= termsService.createTerms(terms);
        return new ResponseEntity<>(newTerms,
                HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Terms>>getAllTerms(){
        List<Terms> terms = termsService.getAllTerms();
        return new ResponseEntity<>(terms, HttpStatus.OK);

    }

}
