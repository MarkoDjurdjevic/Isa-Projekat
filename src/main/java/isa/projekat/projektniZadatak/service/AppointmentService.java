package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.model.Appointments;
import isa.projekat.projektniZadatak.repository.AppointmentRepository;
import isa.projekat.projektniZadatak.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

  private final AppointmentRepository appointmentRepository;

  @Autowired
  public AppointmentService(AppointmentRepository appointmentRepository){this.appointmentRepository = appointmentRepository;}

  public void addNewAppointment(Appointments appointments){appointmentRepository.save(appointments);}

}
