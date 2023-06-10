package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.model.*;
import isa.projekat.projektniZadatak.repository.AppointmentRepository;
import isa.projekat.projektniZadatak.repository.CentreAdminRepository;
import isa.projekat.projektniZadatak.repository.RegiserUserRepository;
import isa.projekat.projektniZadatak.repository.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminCentreService {

    @Autowired
    private CentreAdminRepository centreAdminRepository;

    @Autowired
    private RegiserUserRepository regiserUserRepository;

    @Autowired
    private UserAppRepository userAppRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    //lista svih usera-registrovanih
    public List<Appointments> appointmentsList(){
        return  appointmentRepository.findAll();
    }

    public RegisterUser searchRegisterUser(String name, String lastname){
        UserApp loggedInUser = userAppRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        if (loggedInUser.getRole().getName().equals("CENTRE_ADMINISTRATOR")) {
            RegisterUser registerUser = regiserUserRepository.findRegisterUserByNameAndLastname(name,lastname);

            return registerUser;
        }
        return null;

    }


    public CentreAdmin centreAdmin(){

        UserApp loggedInUser = userAppRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        if (loggedInUser.getRole().getName().equals("CENTRE_ADMINISTRATOR")) {
            Optional<CentreAdmin> centreAdmin = centreAdminRepository.findById(loggedInUser.getId());
            CentreAdmin centreAdmin1 = centreAdmin.get();
            return centreAdmin1;
        }
        return null;

    }





}
