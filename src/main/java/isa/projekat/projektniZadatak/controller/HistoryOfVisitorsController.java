package isa.projekat.projektniZadatak.controller;
import isa.projekat.projektniZadatak.model.Appointments;
import isa.projekat.projektniZadatak.model.Equipment;
import isa.projekat.projektniZadatak.model.Statement;
import isa.projekat.projektniZadatak.service.EquipmentService;
import isa.projekat.projektniZadatak.service.HistoryOfRegisterUserService;
import isa.projekat.projektniZadatak.service.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/histories")
@CrossOrigin(origins= "http://localhost:4200/")

public class HistoryOfVisitorsController {

    @Autowired
    private HistoryOfRegisterUserService historyOfVisitorsService;

    @Autowired
    private StatementService statementService;

    @Autowired
    private EquipmentService equipmentService;


    //ovo mogu uraditi po statusu ako pise da je pregledan i ako je to jednako prikazi na ovome samo binduj
    //tj ako je dodato

    @GetMapping("/{id}/allEquipment")
    public List<Equipment>equipmentList(@PathVariable Long id){
        return historyOfVisitorsService.equipmentList(id);

    }

    @GetMapping("/{id}/allStatement")
    public Statement statementList(@PathVariable Long id){
        return historyOfVisitorsService.statementList(id);

    }

//    @GetMapping("/{id}/allAppointment")
//    public List<Appointments> allAppointments(@PathVariable Long id){
//        return historyOfVisitorsService.appointmentsList(id);
//
//    }





}
