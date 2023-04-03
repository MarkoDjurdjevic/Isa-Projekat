package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.model.Appointments;
import isa.projekat.projektniZadatak.model.Report;
import isa.projekat.projektniZadatak.model.dto.ReportDTO;
import isa.projekat.projektniZadatak.repository.AppointmentRepository;
import isa.projekat.projektniZadatak.repository.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    private final ReportRepository reportRepository;
    private final EquipmentService equipmentService;
    private final AppointmentRepository appointmentRepository;

    public ReportService(ReportRepository reportRepository, EquipmentService equipmentService, AppointmentRepository appointmentRepository) {
        this.reportRepository = reportRepository;
        this.equipmentService = equipmentService;
        this.appointmentRepository = appointmentRepository;
    }

    public void addReport(ReportDTO reportDTO,Appointments appointments){
        //Optional<Appointments> appointment = appointmentRepository.findById(appointmentId);
        Report report = new Report();
//        report.setId(reportDTO.getId());
        report.setBloodType(reportDTO.getBloodType());
        report.setNapomenaDoktoruMedicine(reportDTO.getNapomenaDoktoruMedicine());
        report.setBakarSulfat(reportDTO.getBakarSulfat());
        report.setNivo(reportDTO.getNivo());
        report.setHemoglobinometar(reportDTO.getHemoglobinometar());
        report.setVrednost(reportDTO.getVrednost());
        report.setPluca(reportDTO.getPluca());
        report.setSrce(reportDTO.getSrce());
        report.setPritisak(reportDTO.getPritisak());
       // report.setZahtev(reportDTO.isZahtev());
        report.setRazlogOdbijanja(reportDTO.getRazlogOdbijanja());
        report.setPocetak(reportDTO.getPocetak());
        report.setZavrsetak(reportDTO.getZavrsetak());
        report.setMestoPunkcije(reportDTO.getMestoPunkcije());
        report.setKolicinaKrvi(reportDTO.getKolicinaKrvi());
        report.setOstatak(reportDTO.getOstatak());
//       Equipment equipment = new Equipment();
//
//        report.setAppointment(appointment); // set the appointment for the report
//        appointment.setReport(report); // set the report for the appointment
//        report.setEquipment(equipment);
        report.setAppointments(appointments);
        reportRepository.save(report);
        //appointmentRepository.save(appointment);


    }

    public void updatereport(Long id, ReportDTO reportDTO) {
        Optional<Report> reportOptional = reportRepository.findById(id);
        if(reportOptional.isPresent()){
            Report report = reportOptional.get();
            //equipment.setNameEquipment(equipmentDTO.getNameEquipment());
            report.setKolicinaKrvi(reportDTO.getKolicinaKrvi());
            reportRepository.save(report);

        }

    }

    public List<Report> getAllReport(){
        return reportRepository.findAll();
    }

}
