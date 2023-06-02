package isa.projekat.projektniZadatak.repository;

import isa.projekat.projektniZadatak.model.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegiserUserRepository extends JpaRepository<RegisterUser, Long> {

    RegisterUser findRegisterUserByNameAndLastname(String name, String lastname);
}
