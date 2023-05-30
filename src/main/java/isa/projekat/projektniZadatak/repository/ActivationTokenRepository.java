package isa.projekat.projektniZadatak.repository;

import isa.projekat.projektniZadatak.model.ActivationToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ActivationTokenRepository extends JpaRepository<ActivationToken, UUID> {
    public ActivationToken findByHmacValue(String hmacValue);
}
