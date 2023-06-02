package isa.projekat.projektniZadatak.repository;

import isa.projekat.projektniZadatak.model.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAppRepository extends JpaRepository<UserApp, Long> {
    public UserApp findByUsername(String username);

    public boolean existsByUsernameOrEmail(String username, String email);

    public UserApp findByEmail(String email);

    public List<UserApp> findUserAppsByActive(Boolean active);

}