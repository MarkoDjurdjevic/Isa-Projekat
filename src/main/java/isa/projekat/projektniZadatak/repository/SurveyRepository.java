package isa.projekat.projektniZadatak.repository;

import isa.projekat.projektniZadatak.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
