package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.model.Equipment;
import isa.projekat.projektniZadatak.model.HistoryOfVisitors;
import isa.projekat.projektniZadatak.model.Statement;
import isa.projekat.projektniZadatak.model.Users;
import isa.projekat.projektniZadatak.repository.EquipmentRepository;
import isa.projekat.projektniZadatak.repository.HistoryOfVisitorsRepository;
import isa.projekat.projektniZadatak.repository.StatementRepository;
import isa.projekat.projektniZadatak.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryOfVisitorsService {

    @Autowired
    private  HistoryOfVisitorsRepository historyOfVisitorsRepository;

    @Autowired
    private StatementRepository statementRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StatementService statementService;

//    private void addStatementAndEquipmentToHistory(Long id){
//
//        Optional<Users>usersOptional = userRepository.findById(1L);
//        List<Statement>statementList = statementRepository.findAll();
//        List<Equipment>equipmentList = equipmentRepository.findAll();
//
//        if(usersOptional.isPresent()) {
//            if (statementList.isEmpty() || equipmentList.isEmpty()) {
//                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
//            } else {
//                HistoryOfVisitors historyOfVisitors = new HistoryOfVisitors();
//                historyOfVisitors.setEquipmentList(equipmentList);
//                historyOfVisitors.setStatementList(statementList);
//                historyOfVisitorsRepository.save(historyOfVisitors);
//                ResponseEntity.status(HttpStatus.OK);
//            }
//        }

//    }

    public List<Statement> getAllStatements(){
         List<Statement>statementList = statementService.getAllStatements();
         return statementList;
    }

    public List<Equipment>equipmentList(){
        List<Equipment>equipment = equipmentRepository.findAll();
        return  equipment;
    }



}
