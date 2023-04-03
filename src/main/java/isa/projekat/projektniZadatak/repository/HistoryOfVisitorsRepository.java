package isa.projekat.projektniZadatak.repository;

import isa.projekat.projektniZadatak.model.HistoryOfVisitors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface HistoryOfVisitorsRepository extends JpaRepository<HistoryOfVisitors, Long> {
}
