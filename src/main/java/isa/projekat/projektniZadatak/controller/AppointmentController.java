package isa.projekat.projektniZadatak.controller;

import isa.projekat.projektniZadatak.model.Appointments;
import isa.projekat.projektniZadatak.model.Centre;
import isa.projekat.projektniZadatak.repository.CentreRepository;
import isa.projekat.projektniZadatak.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path ="/appointments")
@CrossOrigin(origins= "http://localhost:4200/")
public class AppointmentController {

  private final AppointmentService appointmentService;
  private final CentreRepository centreRepository;

  @Autowired
  public AppointmentController(AppointmentService appointmentService, CentreRepository centreRepository){
    this.appointmentService = appointmentService;
    this.centreRepository = centreRepository;
  }

  @PostMapping("/add")
  public void addAppointment(@RequestBody Appointments appointment){
    Optional<Centre> centreOptional = centreRepository.findById(appointment.getCentreId());
    if(centreOptional.isPresent()){
      Centre centre = centreOptional.get();
     // centre.getAppointments().add(appointment); //dodato

      appointment.setCentreAppointment(centre);
      appointmentService.addNewAppointment(appointment);
      //centreRepository.save(centre); //dodato
    } else {
      System.out.println("Neka greska je u dodavnju appointmenta");
    }
  }

}
