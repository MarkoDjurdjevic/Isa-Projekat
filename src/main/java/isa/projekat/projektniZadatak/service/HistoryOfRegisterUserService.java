package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.model.*;
import isa.projekat.projektniZadatak.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryOfRegisterUserService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private StatementRepository statementRepository;

    @Autowired
    private UserAppRepository userAppRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private RegiserUserRepository regiserUserRepository;


    //pronaci korisnika preko svog id i iz njega izvuci sve equipmente, preko appointmenta proveriti prvo tj naci ga preko register usera pa onda pozvati ga
    //preko id registrovamog korisnika koji se nalazi u appointmentu da izvucem odg korisnika i tu onda radim
    public List<Equipment>equipmentList(Long id){
        UserApp loggedInUser = userAppRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        if (loggedInUser.getRole().getName().equals("CENTRE_ADMINISTRATOR")) {
//            Optional<Appointments>appointmentsOptional = appointmentRepository.findById(id);
//            Appointments appointments = appointmentsOptional.get();
//            return appointments.getEquipmentList();
//
////            RegisterUser registerUser = appointments.getRegisterUser();
////            if(registerUser != null){
////                List<Equipment>equipmentList = registerUser.getAppointments().getEquipmentList();
////                return equipmentList;
////            }
//        }
//        return null;

            Optional<RegisterUser>registerUser = regiserUserRepository.findById(id);
            if(registerUser.isPresent()){
                RegisterUser registerUser1 = registerUser.get();
                List<Equipment>equipmentList =  registerUser1.getAppointments().getEquipmentList();
                return equipmentList;
            }

        }
        return null;

    }

    public Statement statementList(Long id) {
        UserApp loggedInUser = userAppRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        if (loggedInUser.getRole().getName().equals("CENTRE_ADMINISTRATOR")) {
            Optional<RegisterUser> registerUser = regiserUserRepository.findById(id);
            if (registerUser.isPresent()) {
                RegisterUser registerUser1 = registerUser.get();
                Appointments appointments = appointmentRepository.getAppointmentByRegisterUser(registerUser1);
                Statement statement = appointments.getStatement();
                return statement;

            }


        }
        return null;
    }

//    public Appointments appointmentsList(Long id){
//        UserApp loggedInUser = userAppRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
//        if (loggedInUser.getRole().getName().equals("CENTRE_ADMINISTRATOR")) {
//            Optional<RegisterUser> registerUser = regiserUserRepository.findById(id);
//            if (registerUser.isPresent()) {
//                RegisterUser registerUser1 = registerUser.get();
////                Appointments appointment = registerUser1.getAppointments();
////                List<Appointments>appointmentsList = new ArrayList<>();
////                appointmentsList.add(appointment);
////                return appointmentsList;
//
//                List<Appointments>appointmentsList = appointmentRepository.findAll();
//                List<Appointments>newAppointmentsList = new ArrayList<>();
//                for (Appointments appointment:appointmentsList
//                     ) {
//                    if(appointment.getRegisterUser().equals(registerUser1)){
//                        newAppointmentsList.add(appointment);
//                    }
//
//                }
//                System.out.println("aaaaaaaaaaaaaaaaaaaaaa" + newAppointmentsList.size());
//                return newAppointmentsList;
//
//            }
//
//        }
//        return null;
//
//    }
}
