package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.model.*;
import isa.projekat.projektniZadatak.model.dto.RateForCentreDTO;
import isa.projekat.projektniZadatak.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RateForCentreService {

    @Autowired
   private RateForCentreRepository rateForCentreRepository;

    @Autowired
    private UserAppRepository userAppRepository;
    @Autowired
    private CentreAdminRepository centreAdminRepository;
    @Autowired
    private CentreRepository centreRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private RegiserUserRepository regiserUserRepository;



    public void RateCentre(RateForCentreDTO rateForCentreDTO) {
//        UserApp loggedInUser = userAppRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
//        if (loggedInUser.getRole().getName().equals("REGISTERED_USER")) {
//            Optional<RegisterUser>registerUser = regiserUserRepository.findById(loggedInUser.getId());
//            RegisterUser registerUser1 = registerUser.get();
//            Appointments appointments = appointmentRepository.getAppointmentByRegisterUser(registerUser1);
//            Optional<Centre>centreOptional = centreRepository.findById(appointments.getId());
//            Centre centre = centreOptional.get();
//            if(centreOptional.isPresent()){
//                RateForCenter rateForCenter = new RateForCenter();
//                rateForCenter.setCentre(centre);
//                rateForCenter.setRegisterUser(registerUser1);
//                rateForCenter.setRate(rateForCentreDTO.getRate());
//                rateForCentreRepository.save(rateForCenter);
//            }
//
//        }

        UserApp loggedInUser = userAppRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        if (loggedInUser.getRole().getName().equals("REGISTERED_USER")) {
            Optional<RegisterUser> registerUser = regiserUserRepository.findById(loggedInUser.getId());
            RegisterUser registerUser1 = registerUser.get();
            Appointments appointments = appointmentRepository.getAppointmentByRegisterUser(registerUser1);
            Optional<Centre> centreOptional = centreRepository.findById(appointments.getId());

            if (centreOptional.isPresent()) {
                Centre centre = centreOptional.get();


                Optional<RateForCenter> existingRateOptional = rateForCentreRepository.findByCentreAndRegisterUser(centre, registerUser1);

                if (existingRateOptional.isPresent()) {

                    RateForCenter existingRate = existingRateOptional.get();
                    existingRate.setRate(rateForCentreDTO.getRate());
                    rateForCentreRepository.save(existingRate);
                } else {

                    RateForCenter rateForCenter = new RateForCenter();
                    rateForCenter.setCentre(centre);
                    rateForCenter.setRegisterUser(registerUser1);
                    rateForCenter.setRate(rateForCentreDTO.getRate());
                    rateForCentreRepository.save(rateForCenter);
                }
            }
        }
    }

}
