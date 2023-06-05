package isa.projekat.projektniZadatak.controller;

import isa.projekat.projektniZadatak.model.Centre;
import isa.projekat.projektniZadatak.model.Terms;
import isa.projekat.projektniZadatak.model.dto.TermsDTO;
import isa.projekat.projektniZadatak.service.TermsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyAuthority('CENTRE_ADMINISTRATOR')")
    public void createTerms(@RequestBody TermsDTO terms){
        termsService.createTerms(terms);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('CENTRE_ADMINISTRATOR','REGISTERED_USER')")
    public List<Terms>getAllTerms(){
        return termsService.getAllTerms();
    }

    //svi slobodni termini
    @GetMapping("/allTermsList")
    @PreAuthorize("hasAnyAuthority('CENTRE_ADMINISTRATOR','REGISTERED_USER')")
    public List<Terms>getTermsListForRegisterUser(){
        return termsService.termsList();
    }

    @PutMapping("/{id}/reserve")
    @PreAuthorize("hasAnyAuthority('REGISTERED_USER')")
    public Terms reserveTerms(@PathVariable Long id){
        return termsService.updateTerms(id);
    }

//    @PutMapping("/{id}/reservePr")
//    @PreAuthorize("hasAnyAuthority('CENTRE_ADMINISTRATOR')")
//    public void proveraTerms(@PathVariable Long id){
//        termsService.proveraTerms(id);
//    }

}
