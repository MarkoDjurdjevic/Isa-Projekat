package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.model.BloodType;
import isa.projekat.projektniZadatak.repository.BloodTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloodTypeService {

    @Autowired
    private BloodTypeRepository bloodRepository;

    public BloodType findByName(String name){
        return bloodRepository.findByName(name);
    }
}
