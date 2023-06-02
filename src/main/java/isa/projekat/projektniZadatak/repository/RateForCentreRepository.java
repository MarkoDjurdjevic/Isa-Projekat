package isa.projekat.projektniZadatak.repository;

import isa.projekat.projektniZadatak.model.RateForCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface RateForCentreRepository extends JpaRepository<RateForCenter, Long> {
}
