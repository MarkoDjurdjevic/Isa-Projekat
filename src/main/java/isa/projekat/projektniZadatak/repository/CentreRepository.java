package isa.projekat.projektniZadatak.repository;

import isa.projekat.projektniZadatak.model.Centre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CentreRepository extends JpaRepository<Centre, Long> {
    @Query("SELECT c from Centre c WHERE c.number=?1")
    Optional<Centre> findCentreByAdress(int number);

    @Query("SELECT c FROM Centre c WHERE c.name = ?1 OR c.number = ?2")
    Optional<Centre> findCentreByNameOrAddress(String name, int number);
}
