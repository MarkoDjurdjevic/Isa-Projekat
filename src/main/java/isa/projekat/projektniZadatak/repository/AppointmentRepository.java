package isa.projekat.projektniZadatak.repository;

import isa.projekat.projektniZadatak.model.Appointments;
import isa.projekat.projektniZadatak.model.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointments, Long> {

    public Appointments getAppointmentByRegisterUser(RegisterUser registerUser);

}
