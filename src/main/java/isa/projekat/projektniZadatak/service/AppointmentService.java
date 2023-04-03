package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.model.Appointments;
import isa.projekat.projektniZadatak.model.Equipment;
import isa.projekat.projektniZadatak.model.Report;
import isa.projekat.projektniZadatak.model.dto.EquipmentDTO;
import isa.projekat.projektniZadatak.model.dto.ReportDTO;
import isa.projekat.projektniZadatak.repository.AppointmentRepository;
import isa.projekat.projektniZadatak.repository.EquipmentRepository;
import isa.projekat.projektniZadatak.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {

  private final AppointmentRepository appointmentRepository;
  private final ReportService reportService;
  private final ReportRepository reportRepository;

  private final EquipmentService equipmentService;
  private final EquipmentRepository equipmentRepository;


  @Autowired
  public AppointmentService(AppointmentRepository appointmentRepository, ReportService reportService,
                            ReportRepository reportRepository, EquipmentService equipmentService,
                            EquipmentRepository equipmentRepository){
    this.appointmentRepository = appointmentRepository;
    this.reportService = reportService;
    this.reportRepository = reportRepository;
    this.equipmentService = equipmentService;
    this.equipmentRepository = equipmentRepository;
  }

  public void addNewAppointment(Appointments appointments){
//    Appointments appointments = new Appointments();
//    appointments.setDate(appointmentDTO.getDate());
//    appointments.setTime(appointmentDTO.getTime());
//    appointments.setDuration(appointmentDTO.getDuration());
//    appointments.setAvailable(appointmentDTO.isAvailable());
//    appointments.setBloodType(appointmentDTO.getBloodType());

    appointmentRepository.save(appointments);}

  public List<Appointments> getAppointments(){
    return appointmentRepository.findAll();
  }

  public Appointments getAppointmentById(long id) {
    return appointmentRepository.findById(id).orElse(null);
  }

  public Appointments updateAppointment(Appointments appointment) {

    Appointments app = appointmentRepository.findById(appointment.getId()).orElseThrow(() -> new IllegalStateException("student with id does not exist"));
    app.setAvailable(false);
    return appointmentRepository.save(app);
  }

  public void addApointment(Appointments appointments){
    appointmentRepository.save(appointments);
  }


  public void addReportToApointment(Long appontmentId, ReportDTO reportDTO,List<EquipmentDTO> equipmentDTOs){

    Appointments appointment = appointmentRepository.findById(appontmentId)
            .orElseThrow(() -> new EntityNotFoundException("Appointment not found with id: " + appontmentId));


      //Report report = new Report();
      reportService.addReport(reportDTO, appointment);
      //report.setAppointments(appointment);


    for (EquipmentDTO equipmentDTO : equipmentDTOs) {
      Equipment equipment = new Equipment();
     equipmentService.createEquipment(equipmentDTO,appointment);
      //equipment.setAppointments(appointment);
      equipmentRepository.save(equipment);
      List<Equipment> equipmentList = new ArrayList<>();
      equipmentList.add(equipment);
      appointment.setEquipment(equipmentList);
    }

    appointmentRepository.save(appointment);


  }

//  public void addEquipmentToAppointment(Long appontmentId, EquipmentDTO equipmentDTO){
//
//    Appointments appointment = appointmentRepository.findById(appontmentId)
//            .orElseThrow(() -> new EntityNotFoundException("Appointment not found with id: " + appontmentId));
//
//    List<Equipment>equipmentList = appointment.getEquipment();
//    Equipment equipment = new Equipment();
//    equipmentService.createEquipment(equipmentDTO);
//    equipment.setAppointments(appointment);
//    equipmentRepository.save(equipment);
//    equipmentList.add(equipment);
//    appointment.setEquipment(equipmentList);
//    appointmentRepository.save(appointment);
//
//
//
//
//  }

}
