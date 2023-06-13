package isa.projekat.projektniZadatak.repository;

import isa.projekat.projektniZadatak.model.Centre;
import isa.projekat.projektniZadatak.model.RateForCenter;
import isa.projekat.projektniZadatak.model.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Repository
public interface RateForCentreRepository extends JpaRepository<RateForCenter, Long> {
    Optional<RateForCenter> findByCentreAndRegisterUser(Centre centre, RegisterUser registerUser1);
}
