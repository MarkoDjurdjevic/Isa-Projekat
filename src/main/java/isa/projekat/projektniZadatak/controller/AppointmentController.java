package isa.projekat.projektniZadatak.controller;

import isa.projekat.projektniZadatak.model.Appointments;
import isa.projekat.projektniZadatak.model.Centre;
import isa.projekat.projektniZadatak.model.dto.EquipmentDTO;
import isa.projekat.projektniZadatak.model.dto.StatementDTO;
import isa.projekat.projektniZadatak.repository.AppointmentRepository;
import isa.projekat.projektniZadatak.repository.CentreRepository;
import isa.projekat.projektniZadatak.service.AppointmentService;
import isa.projekat.projektniZadatak.service.EquipmentService;
import isa.projekat.projektniZadatak.service.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path ="/appointments")
@CrossOrigin(origins= "http://localhost:4200/")
public class AppointmentController {

  private final AppointmentService appointmentService;
  private final CentreRepository centreRepository;

  private final AppointmentRepository appointmentRepository;
  private final StatementService statementService;

  private final EquipmentService equipmentService;

  @Autowired
  public AppointmentController(AppointmentService appointmentService, CentreRepository centreRepository, AppointmentRepository appointmentRepository, StatementService statementService, EquipmentService equipmentService){
    this.appointmentService = appointmentService;
    this.centreRepository = centreRepository;
    this.appointmentRepository = appointmentRepository;
    this.statementService = statementService;
    this.equipmentService = equipmentService;
  }

  @GetMapping("/{id}")
  public Appointments getAppointmentById(@PathVariable long id) {
    return appointmentService.getAppointmentById(id);
  }


  @GetMapping("/all")
  public List<Appointments> getAppointments(){
    return appointmentService.getAppointments();
  }

//  @PutMapping("/update/")
//  public ResponseEntity<Appointments> updateAppointment(@RequestBody Appointments appointment) {
//
//
//    Appointments appointmentToUpdate = appointmentService.getAppointmentById(appointment.getId());
//
//    return ResponseEntity.ok(appointmentToUpdate);
//
//  }

  @PutMapping("/update/")
  public ResponseEntity<Appointments> updateAppointment(@RequestBody Appointments appointment) {
    Appointments appointmentToUpdate = appointmentService.getAppointmentById(appointment.getId());
    appointmentToUpdate.setAvailable(false);
    Appointments updatedAppointment = appointmentService.updateAppointment(appointmentToUpdate);
    return ResponseEntity.ok(updatedAppointment);
  }

  @PostMapping("/add")
  public void addAppointment(@RequestBody Appointments appointment){
    Optional<Centre> centreOptional = centreRepository.findById(appointment.getCentreId());
    if(centreOptional.isPresent()){
      Centre centre = centreOptional.get();
      centre.getAppointments().add(appointment); //dodato

      appointment.setCentreAppointment(centre);
      appointmentService.addNewAppointment(appointment);
       centreRepository.save(centre); //dodato
    } else {
      System.out.println("Neka greska je u dodavnju appointmenta");
    }
  }


  @PostMapping("/{id}/add")
  public void addStatements(@PathVariable Long id,  @RequestBody StatementDTO statementDTO){
    statementService.createStatement(id,statementDTO);
  }

  @PostMapping("/{id}/addEquipment")
    public void registerNewEquipment(@PathVariable Long id,@RequestBody EquipmentDTO equipment){
        equipmentService.createEquipment(id,equipment);
    }

//  @PostMapping("/{id}/available")
//  public void registerNewEquipment(@PathVariable Long id,@RequestBody Appointments equipment){
//    appointmentService.addPenal(id);
//  }

}
