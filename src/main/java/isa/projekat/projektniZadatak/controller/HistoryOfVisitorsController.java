package isa.projekat.projektniZadatak.controller;

import isa.projekat.projektniZadatak.model.Report;
import isa.projekat.projektniZadatak.repository.ReportRepository;
import isa.projekat.projektniZadatak.service.HistoryOfVisitorsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path ="/histories")
@CrossOrigin(origins= "http://localhost:4200/")

public class HistoryOfVisitorsController {

    private final HistoryOfVisitorsService historyOfVisitorsService;
    private final ReportRepository reportRepository;

    public HistoryOfVisitorsController(HistoryOfVisitorsService historyOfVisitorsService,
                                       ReportRepository reportRepository) {
        this.historyOfVisitorsService = historyOfVisitorsService;
        this.reportRepository = reportRepository;
    }

    @GetMapping("/allReports")
    public List<Report>getAllReport(){
        return historyOfVisitorsService.getAllReport();
    }
    @GetMapping("/allEquipment")
    public void getALlEquipment(){
        historyOfVisitorsService.getALlEquipment();
    }
}
