package isa.projekat.projektniZadatak.repository;

import isa.projekat.projektniZadatak.model.Statement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatementRepository extends JpaRepository<Statement,Long> {
}
