package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.model.Appointments;
import isa.projekat.projektniZadatak.model.dto.EquipmentDTO;
import isa.projekat.projektniZadatak.model.dto.StatementDTO;
import isa.projekat.projektniZadatak.repository.AppointmentRepository;
import isa.projekat.projektniZadatak.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

  private final AppointmentRepository appointmentRepository;

  private final StatementService statementService;

  private final EquipmentService equipmentService;
  private final EquipmentRepository equipmentRepository;


  @Autowired
  public AppointmentService(AppointmentRepository appointmentRepository, StatementService statementService, EquipmentService equipmentService,
                            EquipmentRepository equipmentRepository){
    this.appointmentRepository = appointmentRepository;
    this.statementService = statementService;
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



}
