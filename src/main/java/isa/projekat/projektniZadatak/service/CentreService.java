package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.model.Centre;
import isa.projekat.projektniZadatak.repository.CentreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
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
    public void updateCentre(Long centreId, String name,String address,String description) {
        Centre centre = centreRepository.findById(centreId).orElseThrow(() -> new IllegalStateException("student with id does not exist"));

        if(name != null && name.length() > 0 && !Objects.equals(centre.getName(), name)){
            centre.setName(name);
        }

        if(description != null && description.length() > 0 && !Objects.equals(centre.getDescription(), description)){
            centre.setDescription(description);
        }

        if(address != null && address.length() > 0 && !Objects.equals(centre.getAdress(), address)){
            centre.setAdress(address);
        }

    }



    public List<Centre>sortByName(String byWhatOrder){
        List<Centre> centres = new ArrayList<>();
        if(byWhatOrder.equals("Ascending")){
            centres = centreRepository.findAllByOrderByNameAsc();
        }else{
            centres = centreRepository.findAllByOrderByNameDesc();
        }
        return centres;

    }

    public List<Centre>sortByAdress(String byWhatOrder){
        List<Centre> centres = new ArrayList<>();
        if(byWhatOrder.equals("Ascending")){
            centres = centreRepository.findAllByOrderByAdressAsc();
        }else{
            centres = centreRepository.findAllByOrderByAdressDesc();
        }
        return centres;

    }

    public List<Centre>sortByAvgGrade(String byWhatOrder){
        List<Centre> centres = new ArrayList<>();
        if(byWhatOrder.equals("Ascending")){
            centres = centreRepository.findAllByOrderByAvgGradeAsc();
        }else{
            centres = centreRepository.findAllByOrderByAvgGradeDesc();
        }
        return centres;

    }




}
