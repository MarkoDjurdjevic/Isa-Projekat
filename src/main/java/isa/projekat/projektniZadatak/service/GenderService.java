package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.model.Gender;
import isa.projekat.projektniZadatak.model.Role;
import isa.projekat.projektniZadatak.repository.GenderRepository;
import isa.projekat.projektniZadatak.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenderService {
    @Autowired
    private GenderRepository genderRepository;

    public Gender findByName(String name){
        return genderRepository.findByName(name);
    }
}
