package isa.projekat.projektniZadatak.repository;

import isa.projekat.projektniZadatak.model.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterUserRepository extends JpaRepository<RegisterUser, Long> {

    RegisterUser findRegisterUserByNameAndLastname(String name, String lastname);
}
