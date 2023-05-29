package isa.projekat.projektniZadatak.service;


import isa.projekat.projektniZadatak.model.Equipment;
import isa.projekat.projektniZadatak.model.Report;
import isa.projekat.projektniZadatak.model.Statement;
import isa.projekat.projektniZadatak.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private StatementService statementService;

    @Autowired
    private EquipmentService equipmentService;



}
