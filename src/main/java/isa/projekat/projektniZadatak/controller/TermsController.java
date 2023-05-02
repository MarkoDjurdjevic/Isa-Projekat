package isa.projekat.projektniZadatak.controller;

import isa.projekat.projektniZadatak.model.Centre;
import isa.projekat.projektniZadatak.model.Terms;
import isa.projekat.projektniZadatak.model.dto.TermsDTO;
import isa.projekat.projektniZadatak.service.TermsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/terms")
@CrossOrigin(origins= "http://localhost:4200/")
public class TermsController {
    private  final TermsService termsService;

    @Autowired
    public TermsController( TermsService termsService) {
        this.termsService = termsService;

    }


    @PostMapping("/add")
    public ResponseEntity<Terms>createTerms(@RequestBody TermsDTO terms){
        termsService.createTerms(terms);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/all")
    public List<Terms>getAllTerms(){
        return termsService.getAllTerms();
    }

}
