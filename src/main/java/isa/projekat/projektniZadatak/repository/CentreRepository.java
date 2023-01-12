package isa.projekat.projektniZadatak.repository;

import isa.projekat.projektniZadatak.model.Centre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CentreRepository extends JpaRepository<Centre, Long> {
    @Query("SELECT c from Centre c WHERE c.adress=?1")
    Optional<Centre> findCentreByAdress(String adress);

    @Query("SELECT c FROM Centre c WHERE c.name = ?1 OR c.adress = ?2")
    Optional<Centre> findCentreByNameOrAddress(String name, String address);

    @Query("Select c FROM Centre c WHERE  NOT EXISTS ( SELECT a FROM c.appointments a WHERE a.date = :date AND a.time = :time )")
    List<Centre> findByAvailableAppointments(@Param("date") LocalDate date, @Param("time") String time);
}
