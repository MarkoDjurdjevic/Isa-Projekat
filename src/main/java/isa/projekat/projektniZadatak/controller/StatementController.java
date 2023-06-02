package isa.projekat.projektniZadatak.controller;

import isa.projekat.projektniZadatak.model.Statement;
import isa.projekat.projektniZadatak.model.dto.StatementDTO;
import isa.projekat.projektniZadatak.service.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(path ="/statements")
@CrossOrigin(origins= "http://localhost:4200/")
public class StatementController {

    private final StatementService statementService;

    @Autowired
    public StatementController(StatementService statementService) {
        this.statementService = statementService;
    }

//    @PostMapping("/{id}/add")
//    @PreAuthorize("hasAnyAuthority('CENTRE_ADMINISTRATOR')")
//    public void addStatements(@RequestParam Long id,  @RequestBody StatementDTO statementDTO){
//        statementService.createStatement(id,statementDTO);
//    }

    @GetMapping("/all")
    public List<Statement> statementList (){
        List<Statement>statementList = statementService.getAllStatements();
        return statementList;
    }
    @PutMapping("/{id}/update")
    public void statementList (@PathVariable Long id, @RequestBody StatementDTO statementDTO){
        statementService.updateStatement(id, statementDTO);
    }

}
