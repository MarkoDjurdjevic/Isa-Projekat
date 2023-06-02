package isa.projekat.projektniZadatak.repository;

import isa.projekat.projektniZadatak.model.BloodType;
import isa.projekat.projektniZadatak.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodTypeRepository extends JpaRepository<BloodType,Long> {

    public BloodType findByName(String name);
}
