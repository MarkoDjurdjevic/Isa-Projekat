package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.model.Appointments;
import isa.projekat.projektniZadatak.model.Centre;
import isa.projekat.projektniZadatak.repository.AppointmentRepository;
import isa.projekat.projektniZadatak.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class AppointmentService {

  private final AppointmentRepository appointmentRepository;

  @Autowired
  public AppointmentService(AppointmentRepository appointmentRepository){this.appointmentRepository = appointmentRepository;}

  public void addNewAppointment(Appointments appointments){appointmentRepository.save(appointments);}

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


}
