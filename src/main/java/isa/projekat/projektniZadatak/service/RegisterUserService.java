package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.model.Appointments;
import isa.projekat.projektniZadatak.model.RegisterUser;
import isa.projekat.projektniZadatak.repository.AppointmentRepository;
import isa.projekat.projektniZadatak.repository.RegiserUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RegisterUserService {

    @Autowired
    private RegiserUserRepository regiserUserRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;


    public List<RegisterUser> registerUserList(){
        return  regiserUserRepository.findAll();
    }
    public List<RegisterUser>getAllRegisterUserByAppointment(){
        List<Appointments> appointmentsOptional = appointmentRepository.findAll();
        List<RegisterUser>registerUsers = regiserUserRepository.findAll();
        List<RegisterUser>newRegisterUser = new ArrayList<>();
        for (RegisterUser registerUser:registerUsers
             ) {
            if(!registerUser.getAppointments().getId().equals(null)){
                newRegisterUser.add(registerUser);
            }else{
                registerUsers.add(registerUser);
            }
        }

        return newRegisterUser;
    }

    public void findRegisterUserById(Long id){
        Optional<RegisterUser>registerUser = regiserUserRepository.findById(id);
    }
}
