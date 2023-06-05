package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.model.Appointments;
import isa.projekat.projektniZadatak.model.RegisterUser;
import isa.projekat.projektniZadatak.model.UserApp;
import isa.projekat.projektniZadatak.model.dto.AppointmentDTO;
import isa.projekat.projektniZadatak.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
  private UserAppRepository userAppRepository;

  @Autowired
  private RegisterUserRepository registerUserRepository;
  private final HistoryOfRegisterUserRepository historyOfRegisterUserRepository;


  @Autowired
  public AppointmentService(AppointmentRepository appointmentRepository, StatementService statementService, EquipmentService equipmentService,
                            EquipmentRepository equipmentRepository,
                            HistoryOfRegisterUserRepository historyOfRegisterUserRepository,
                            RegisterUserRepository registerUserRepository){
    this.appointmentRepository = appointmentRepository;
    this.statementService = statementService;
    this.equipmentService = equipmentService;
    this.equipmentRepository = equipmentRepository;
    this.historyOfRegisterUserRepository = historyOfRegisterUserRepository;
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

//  public Appointments getAppointmentsForUser(Long userId) {
//    UserApp loggedInUser = userAppRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
//    if (loggedInUser.getRole().getName().equals("CENTRE_ADMINISTRATOR")) {
//      try {
//        Optional<RegisterUser> registerUserOptional = regiserUserRepository.findById(userId);
//        if (registerUserOptional.isPresent()) {
//          RegisterUser registerUser = registerUserOptional.get();
//          Appointments appointments = registerUser.getAppointments();
//          return appointments;
//        }
//      }catch (Exception e){
//        System.out.println("ne znam nesto nece");
//      }
//    }
//    return null;
//  }

  public Appointments getAppointmentsForUser(Long userId){
    UserApp loggedInUser = userAppRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    if (loggedInUser.getRole().getName().equals("CENTRE_ADMINISTRATOR")) {

    Optional<RegisterUser>registerUserOptional = registerUserRepository.findById(userId);
    if(registerUserOptional.isPresent()){
      RegisterUser registerUser = registerUserOptional.get();
      Optional<Appointments> appointments = appointmentRepository.findById(registerUser.getAppointments().getId());
      Appointments appointments1 = appointments.get();
      return appointments1;
    }else{
      System.out.println("can not bring appointment");
    }

    }
    return null;
  }



  //da kada na frontu pritisnem dugme za available
  // i ovo premestiti i staviti u register usera
  public void updateAvailability(Long appointmentId,AppointmentDTO appointmentDTO){
    UserApp loggedInUser = userAppRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    if (loggedInUser.getRole().getName().equals("CENTRE_ADMINISTRATOR")) {
      Optional<RegisterUser>registerUserOptional = registerUserRepository.findById(appointmentId);
      if(registerUserOptional.isPresent()){
        RegisterUser registerUser = registerUserOptional.get();
        Appointments appointments = registerUser.getAppointments();
//        if (appointments != null){
//          appointments.setAvailable(true);
//          appointments.setPresent(true);
//          appointmentRepository.save(appointments);
          if(appointments.isAvailable()){
            appointments.setAvailable(!appointmentDTO.isAvailable());
            appointments.setPresent(false);
            int penal = registerUser.getPenal();
            penal = penal+1;
            registerUser.setPenal(penal);
            appointmentRepository.save(appointments);
            registerUserRepository.save(registerUser);
          }
//          else{
//            appointments.setAvailable(is);
//            appointments.setPresent(true);
//            appointmentRepository.save(appointments);
//          }
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
        Optional<RegisterUser>registerUserOptional = registerUserRepository.findById(appointment.getRegisterUser().getId());
        RegisterUser registerUser = registerUserOptional.get();
        int penal = registerUser.getPenal();
        penal = penal+1;
        registerUser.setPenal(penal);
        registerUserRepository.save(registerUser);

      }

    }
  }


}
