package isa.projekat.projektniZadatak.repository;

import isa.projekat.projektniZadatak.model.HistoryOfRegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryOfRegisterUserRepository extends JpaRepository<HistoryOfRegisterUser, Long> {
}
