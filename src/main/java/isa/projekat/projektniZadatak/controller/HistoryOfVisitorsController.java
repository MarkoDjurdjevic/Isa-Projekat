package isa.projekat.projektniZadatak.controller;
import isa.projekat.projektniZadatak.model.Equipment;
import isa.projekat.projektniZadatak.model.Statement;
import isa.projekat.projektniZadatak.model.dto.StatementDTO;
import isa.projekat.projektniZadatak.service.EquipmentService;
import isa.projekat.projektniZadatak.service.HistoryOfVisitorsService;
import isa.projekat.projektniZadatak.service.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/histories")
@CrossOrigin(origins= "http://localhost:4200/")

public class HistoryOfVisitorsController {

    @Autowired
    private HistoryOfVisitorsService historyOfVisitorsService;

    @Autowired
    private StatementService statementService;

    @Autowired
    private EquipmentService equipmentService;


    //ovo mogu uraditi po statusu ako pise da je pregledan i ako je to jednako prikazi na ovome samo binduj
    //tj ako je dodato

    @GetMapping("/allEquipment")
    public List<Equipment>equipmentList(){
        return historyOfVisitorsService.equipmentList();

    }

    @GetMapping("/allStatement")
    public List<Statement>statementList(){
        return historyOfVisitorsService.getAllStatements();

    }





}
