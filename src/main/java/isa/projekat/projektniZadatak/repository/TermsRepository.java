package isa.projekat.projektniZadatak.repository;

import isa.projekat.projektniZadatak.model.Terms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TermsRepository extends JpaRepository<Terms,Long> {


}
