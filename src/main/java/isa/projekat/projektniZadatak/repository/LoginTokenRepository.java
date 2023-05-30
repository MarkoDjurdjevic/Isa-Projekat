package isa.projekat.projektniZadatak.repository;

import isa.projekat.projektniZadatak.model.LoginToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoginTokenRepository extends JpaRepository<LoginToken, UUID> {
    public LoginToken findByHmacValue(String hmacValue);

}
