package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.model.Appointments;
import isa.projekat.projektniZadatak.model.RegisterUser;
import isa.projekat.projektniZadatak.model.UserApp;
import isa.projekat.projektniZadatak.model.dto.AppointmentDTO;
import isa.projekat.projektniZadatak.model.dto.EquipmentDTO;
import isa.projekat.projektniZadatak.model.dto.StatementDTO;
import isa.projekat.projektniZadatak.repository.AppointmentRepository;
import isa.projekat.projektniZadatak.repository.EquipmentRepository;
import isa.projekat.projektniZadatak.repository.RegiserUserRepository;
import isa.projekat.projektniZadatak.repository.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

  private final AppointmentRepository appointmentRepository;

  private final StatementService statementService;

  private final EquipmentService equipmentService;
  private final EquipmentRepository equipmentRepository;

  @Autowired
  private UserAppRepository userAppRepository;
  private final RegiserUserRepository regiserUserRepository;


  @Autowired
  public AppointmentService(AppointmentRepository appointmentRepository, StatementService statementService, EquipmentService equipmentService,
                            EquipmentRepository equipmentRepository,
                            RegiserUserRepository regiserUserRepository){
    this.appointmentRepository = appointmentRepository;
    this.statementService = statementService;
    this.equipmentService = equipmentService;
    this.equipmentRepository = equipmentRepository;
    this.regiserUserRepository = regiserUserRepository;
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

  public List<Appointments> getAppointmentsForUser(Long userId) {
    UserApp loggedInUser = userAppRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    if (loggedInUser.getRole().getName().equals("CENTRE_ADMINISTRATOR")) {
      Optional<RegisterUser> registerUserOptional = regiserUserRepository.findById(userId);
      if (registerUserOptional.isPresent()) {
        List<Appointments> appointmentsOptional = appointmentRepository.findAll();
        List<Appointments> userAppointments = new ArrayList<>();
        for (Appointments appointment : appointmentsOptional) {
          if (appointment.getRegisterUser().equals(registerUserOptional)) {
            userAppointments.add(appointment);
          }
        }
        return userAppointments;
      }
    }
    return Collections.emptyList();
  }



  //da kada na frontu pritisnem dugme za available
  // i ovo premestiti i staviti u register usera
  public void updateAvailability(Long appointmentId, AppointmentDTO appointmentDTO){
    UserApp loggedInUser = userAppRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    if (loggedInUser.getRole().getName().equals("CENTRE_ADMINISTRATOR")) {
      Optional<RegisterUser>registerUserOptional = regiserUserRepository.findById(appointmentId);
      if(registerUserOptional.isPresent()){
        RegisterUser registerUser = registerUserOptional.get();
        Appointments appointments = registerUser.getAppointments();
        if (appointments != null){
          appointments.setAvailable(appointmentDTO.isAvailable());
//          appointmentRepository.save(appointments);
          if(!appointments.isAvailable()){
            appointments.setPresent(false);
            int penal = registerUser.getPenal();
            penal = penal+1;
            registerUser.setPenal(penal);
            appointmentRepository.save(appointments);
            regiserUserRepository.save(registerUser);
          }else{
            appointments.setPresent(true);
            appointmentRepository.save(appointments);
          }
        }
      }

    }
  }

  //ovde postavljam da mi nije korisnik dosao na pregled
  //sve ovo pregled i ovo promeniti da bude sa register user povezano jec ce mi trebati lista register usera koji imaju pregled
  //ja sam ovde nasla pregled za mog korisnika
  public void updatePresent(Long appointmentId){
    UserApp loggedInUser = userAppRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    if (loggedInUser.getRole().getName().equals("CENTRE_ADMINISTRATOR")) {
      Optional<Appointments> appointmentOptional = appointmentRepository.findById(appointmentId);
      if (appointmentOptional.isPresent()) {
        Appointments appointment = appointmentOptional.get();
        appointment.setPresent(false);
        appointmentRepository.save(appointment);
        Optional<RegisterUser>registerUserOptional = regiserUserRepository.findById(appointment.getRegisterUser().getId());
        RegisterUser registerUser = registerUserOptional.get();
        int penal = registerUser.getPenal();
        penal = penal+1;
        registerUser.setPenal(penal);
        regiserUserRepository.save(registerUser);

      }

    }
  }


}
