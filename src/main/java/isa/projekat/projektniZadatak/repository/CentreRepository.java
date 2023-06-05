package isa.projekat.projektniZadatak.repository;

import isa.projekat.projektniZadatak.model.Centre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CentreRepository extends JpaRepository<Centre, Long> {
    @Query("SELECT c from Centre c WHERE c.address=?1")
    Optional<Centre> findCentreByAdress(String adress);

    @Query("SELECT c FROM Centre c WHERE c.name = ?1 OR c.address = ?2")
    Optional<Centre> findCentreByNameOrAddress(String name, String address);


    //@Query("Select c FROM Centre c WHERE  NOT EXISTS ( SELECT a FROM c.appointments a WHERE a.date = :date AND a.time = :time )")
   // List<Centre> findByAvailableAppointments(@Param("date") LocalDate date, @Param("time") String time);

//  @Query("Select c FROM Centre c WHERE NOT EXISTS ( SELECT a FROM c.appointments a WHERE a.date = :date AND (a.time BETWEEN :time and :endTime) )")
// List<Centre> findByAvailableAppointments(@Param("date") LocalDate date, @Param("time") String time, @Param("endTime") String endTime);
//
//  @Query("Select c FROM Centre c WHERE  EXISTS ( SELECT a FROM c.appointments a WHERE a.date = :date AND (a.time = :time and a.available = true) )")
//  List<Centre> findByAvailableAppointmentsRegUser(@Param("date") LocalDate date, @Param("time") String time);


    Optional<Centre> findByName(String name);
}
