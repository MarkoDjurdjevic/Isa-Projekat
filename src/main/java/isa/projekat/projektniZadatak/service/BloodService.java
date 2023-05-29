package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.model.Blood;
import isa.projekat.projektniZadatak.model.Centre;
import isa.projekat.projektniZadatak.model.dto.BloodDTO;
import isa.projekat.projektniZadatak.repository.BloodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodService {

    private final BloodRepository bloodRepository;
    private final CentreService centreService;

    public BloodService(BloodRepository bloodRepository, CentreService centreService) {
        this.bloodRepository = bloodRepository;
        this.centreService = centreService;
    }

    public List<Blood>getAllBlood(){
        return  bloodRepository.findAll();
    }

    public void createBlood(BloodDTO bloodDTO){
        Blood blood = new Blood();

        blood.setId(bloodDTO.getId());
        blood.setAmount(bloodDTO.getAmount());
        blood.setBloodType(bloodDTO.getBloodType());
        List<Centre>centres = centreService.getCentres();
        for(Centre centre: centres){
            blood.setCentre(centre);
        }

        bloodRepository.save(blood);
    }
}
