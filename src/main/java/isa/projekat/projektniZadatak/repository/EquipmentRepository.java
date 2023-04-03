package isa.projekat.projektniZadatak.repository;

import isa.projekat.projektniZadatak.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

    @Query("SELECT e FROM Equipment e WHERE e.nameEquipment = ?1")
    Optional<Equipment> findByName(String name);
}
