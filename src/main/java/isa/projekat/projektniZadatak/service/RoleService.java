package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.model.Role;
import isa.projekat.projektniZadatak.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role findByName(String name){
        return roleRepository.findByName(name);
    }
}
