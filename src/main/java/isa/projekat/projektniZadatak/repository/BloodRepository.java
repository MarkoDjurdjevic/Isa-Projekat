package isa.projekat.projektniZadatak.repository;

import isa.projekat.projektniZadatak.model.Blood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodRepository extends JpaRepository<Blood, Long> {
}
