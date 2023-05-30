package isa.projekat.projektniZadatak.repository;

import isa.projekat.projektniZadatak.model.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, UUID> {
    public RefreshToken findByHmacValue(String hmacValue);

}
