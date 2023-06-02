package isa.projekat.projektniZadatak.repository;

import isa.projekat.projektniZadatak.model.CentreAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CentreAdminRepository extends JpaRepository<CentreAdmin,Long>{

    List<CentreAdmin> findAllCentreAdminById(Long id);
}
