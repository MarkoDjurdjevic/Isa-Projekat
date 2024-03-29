package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.model.Appointments;
import isa.projekat.projektniZadatak.model.Centre;
import isa.projekat.projektniZadatak.repository.CentreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import java.util.Optional;

@Service
public class CentreService {
    private final CentreRepository centreRepository;

    @Autowired
    public CentreService(CentreRepository centreRepository) {
        this.centreRepository = centreRepository;
    }

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


    @Transactional
    public Centre updateCentre(Long centreId, Centre updatedCentre) {
        System.out.println("updateCentre method called with centreId: " + centreId + " and updatedCentre: " + updatedCentre);
        Centre centre = centreRepository.findById(centreId).orElseThrow(() -> new IllegalStateException("student with id does not exist"));
        if (updatedCentre.getName() != null && !Objects.equals(centre.getName(), updatedCentre.getName())) {
            centre.setName(updatedCentre.getName());
        }
        if (updatedCentre.getDescription() != null && !Objects.equals(centre.getDescription(), updatedCentre.getDescription())) {
            centre.setDescription(updatedCentre.getDescription());
        }
        if (updatedCentre.getAdress() != null && !Objects.equals(centre.getAdress(), updatedCentre.getAdress())) {
          centre.setAdress(updatedCentre.getAdress());
        }

        centre.setAppointments(updatedCentre.getAppointments());


        return centreRepository.save(centre);
    }

    public Optional<Centre> searchCentres(String name, String adress){
        return centreRepository.findCentreByNameOrAddress(name,adress);
    }
//bez duration
//    public List<Centre> getAvailableCentres(LocalDate date, String time){
//      return centreRepository.findByAvailableAppointments(date,time);
//    }

  public List<Centre>getAvailableCentresRegUser (LocalDate date, String time){
    return centreRepository.findByAvailableAppointmentsRegUser(date,time);
  }

  public List<Centre> getAvailableCentres(LocalDate date, String time,String duration){
    return centreRepository.findByAvailableAppointments(date,time,duration);
  }

  public Centre getCentreById(Long id) {
    return centreRepository.findById(id).orElseThrow(() -> new IllegalStateException("Centre not found with id " + id));
  }



}
