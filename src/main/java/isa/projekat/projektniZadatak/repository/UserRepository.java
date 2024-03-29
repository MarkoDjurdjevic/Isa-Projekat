package isa.projekat.projektniZadatak.repository;

import isa.projekat.projektniZadatak.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository<Users, Long> {

    @Query("SELECT u FROM Users u WHERE u.name = ?1 and u.lastname = ?2" )
    List<Users> findUserByName(String name, String lastname);

    @Query("Select u FROM Users u WHERE u.email = ?1 and u.password = ?2")
    List<Users> findUserByEmailAndPassword(String email, String password);

    Optional<Users> findByEmail(String email);
}
