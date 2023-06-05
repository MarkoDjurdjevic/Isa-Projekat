package isa.projekat.projektniZadatak.repository;

import isa.projekat.projektniZadatak.model.Appointments;
import isa.projekat.projektniZadatak.model.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointments, Long> {

    public Appointments getAppointmentByRegisterUser(RegisterUser registerUser);

//    @Query( "SELECT * FROM appointments WHERE register_user_id = :userId;")
//    Optional<Appointments> findByUserId(Long id);
}
