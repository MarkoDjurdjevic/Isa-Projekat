package isa.projekat.projektniZadatak.repository;

import isa.projekat.projektniZadatak.model.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointments, Long> {
}
