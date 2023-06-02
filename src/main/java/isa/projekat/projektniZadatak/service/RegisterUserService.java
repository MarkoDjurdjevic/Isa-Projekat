package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.model.RegisterUser;
import isa.projekat.projektniZadatak.repository.RegiserUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterUserService {

    @Autowired
    private RegiserUserRepository regiserUserRepository;


    public List<RegisterUser> registerUserList(){
        return  regiserUserRepository.findAll();
    }
}
