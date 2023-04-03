package isa.projekat.projektniZadatak.controller;

import isa.projekat.projektniZadatak.model.Equipment;
import isa.projekat.projektniZadatak.model.Report;
import isa.projekat.projektniZadatak.model.dto.ReportDTO;
import isa.projekat.projektniZadatak.service.ReportService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path ="/reports")
@CrossOrigin(origins= "http://localhost:4200/")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

//    @PostMapping("/add")
//    public void createReport(@RequestBody ReportDTO report){
//        reportService.addReport(report);
//    }

    @PutMapping("/update/{reportId}")
    public void updateReport(@PathVariable("reportId") Long reportId, @RequestBody ReportDTO reportDTO) {
        reportService.updatereport(reportId, reportDTO);
    }

    @GetMapping("/all")
    public List<Report> getAllReports(){
        return reportService.getAllReport();
    }
}
