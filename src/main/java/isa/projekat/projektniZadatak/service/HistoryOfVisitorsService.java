package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.model.Equipment;
import isa.projekat.projektniZadatak.model.Report;
import isa.projekat.projektniZadatak.repository.HistoryOfVisitorsRepository;
import isa.projekat.projektniZadatak.repository.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryOfVisitorsService {

    private final HistoryOfVisitorsRepository historyOfVisitorsRepository;
    private final ReportService reportService;
    private  final EquipmentService equipmentService;
    private final ReportRepository reportRepository;

    public HistoryOfVisitorsService(HistoryOfVisitorsRepository historyOfVisitorsRepository, ReportService reportService, EquipmentService equipmentService,
                                    ReportRepository reportRepository) {
        this.historyOfVisitorsRepository = historyOfVisitorsRepository;
        this.reportService = reportService;
        this.equipmentService = equipmentService;
        this.reportRepository = reportRepository;
    }

    public List<Report> getAllReport(){
       return reportRepository.findAll();
    }

    public List<Equipment>getALlEquipment(){
        return equipmentService.getAllEquipment();
    }
}
