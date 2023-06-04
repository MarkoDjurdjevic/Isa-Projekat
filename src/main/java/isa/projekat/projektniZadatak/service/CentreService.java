package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.model.*;
import isa.projekat.projektniZadatak.model.dto.CentreDTO;
import isa.projekat.projektniZadatak.repository.CentreAdminRepository;
import isa.projekat.projektniZadatak.repository.CentreRepository;
import isa.projekat.projektniZadatak.repository.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Service
public class CentreService {
    private final CentreRepository centreRepository;

    @Autowired
    public CentreService(CentreRepository centreRepository) {
        this.centreRepository = centreRepository;
    }

    @Autowired
    public CentreAdminRepository centreAdminRepository;

    @Autowired
    public UserAppRepository userAppRepository;

    public void addNewCentre(Centre centre){
        Optional<Centre> centreOptional = centreRepository.findCentreByAdress(centre.getAdress());
        if(centreOptional.isPresent()){
            throw new IllegalStateException("Centre already exists on the following adress");
        }
       centreRepository.save(centre);
    }

    public List<Centre> getCentres(){
        return centreRepository.findAll();
    }

    public void deleteCentre(Long centreId){
        centreRepository.deleteById(centreId);
    }

    public Optional<Centre> searchCentres(String name, String adress){
        return centreRepository.findCentreByNameOrAddress(name,adress);
    }

    public void updateCentre(CentreDTO centreDTO) {
        //kada trazimo centar preko id moramo da njegov objekat smestimo u neku varijablu tj taj drugi objekat
        //Optional se koristi kao kontejner i sadrzi vrednosti jednog objekta
        //sluzi nam za proveru da li neki objekat postoji, a da ne izaziva greske
        //proveravanje optionala/postjanje objekta se vrsi pomocu .isPresent()

        UserApp loggedInUser = userAppRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        if (loggedInUser.getRole().getName().equals("CENTRE_ADMINISTRATOR")) {

            Optional <CentreAdmin> centreAdmin = centreAdminRepository.findById(loggedInUser.getId());
            CentreAdmin centreAdmin1 = centreAdmin.get();
            Optional<Centre> centre = centreRepository.findById(centreAdmin1.getCentre().getId());
            if (centre.isPresent()) {
                centre.get().setName(centreDTO.getName());
                centre.get().setAdress(centreDTO.getAdress());
                centre.get().setDescription(centreDTO.getDescription());
//                centre.get().setAvgGrade(centreDTO.getAvgGrade());
                centreRepository.save(centre.get());
            }

        }
    }


    public List<CentreAdmin> getAllCentreAdmin(){

        List<CentreAdmin>centreAdmins = centreAdminRepository.findAll();
        List<CentreAdmin>centreAdminsList = new ArrayList<>();
        UserApp loggedInUser = userAppRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        if (loggedInUser.getRole().getName().equals("CENTRE_ADMINISTRATOR")) {
            Optional <CentreAdmin> centreAdmin = centreAdminRepository.findById(loggedInUser.getId());
            CentreAdmin centreAdmin1 = centreAdmin.get();
            Optional<Centre> centre = centreRepository.findById(centreAdmin1.getCentre().getId());
            Centre centre1 = centre.get();
            if(centre.isPresent()){
                for (CentreAdmin admin:centreAdmins
                     ) {
                    if(admin.getCentre().getId() == centre1.getId()){
                        centreAdminsList.add(admin);
                    }
                }
            }
        }
        return centreAdminsList;

//        UserApp loggedInUser = userAppRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
//        if (loggedInUser.getRole().getName().equals("CENTRE_ADMINISTRATOR")) {
//            List<CentreAdmin> centreAdmins = centreAdminRepository.findAllCentreAdminById(centreId);
//            return centreAdmins;
//        }
//        return null;


    }

//
//bez duration
//    public List<Centre> getAvailableCentres(LocalDate date, String time){
//      return centreRepository.findByAvailableAppointments(date,time);
//    }

//  public List<Centre>getAvailableCentresRegUser (LocalDate date, String time){
//    return centreRepository.findByAvailableAppointmentsRegUser(date,time);
//  }
//
//  public List<Centre> getAvailableCentres(LocalDate date, String time,String duration){
//    return centreRepository.findByAvailableAppointments(date,time,duration);
//  }

  public Centre getCentreById(Long id) {
    return centreRepository.findById(id).orElseThrow(() -> new IllegalStateException("Centre not found with id " + id));
  }

//  public void rateForCentre(Long centreId, CentreDTO centreDTO) {
//
//        //ovde moram dodati to da je odrzan bar jedan pregled korisnika
//      Optional<Centre> centreOptional = centreRepository.findById(centreId);
//      if (centreOptional.isPresent()) {
//          centreOptional.get().setRate(centreDTO.getRate());
//          centreRepository.save(centreOptional.get());
//      }
//  }

    public Centre findCentreByName(String name){
        Optional<Centre> centreOptional = centreRepository.findByName(name);
        Centre centre = new Centre();
        if(centreOptional.isPresent()){
            centre = centreOptional.get();
        }
        return centre;
    }

//    public List<RegisterUser>registerUserList(Long id){
//        List
//    }



}
