package isa.projekat.projektniZadatak.repository;

import isa.projekat.projektniZadatak.model.Gender;
import isa.projekat.projektniZadatak.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Long> {

    public Gender findByName(String name);
}
