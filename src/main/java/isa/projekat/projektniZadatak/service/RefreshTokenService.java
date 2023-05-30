package isa.projekat.projektniZadatak.service;


import isa.projekat.projektniZadatak.model.RefreshToken;
import isa.projekat.projektniZadatak.model.UserApp;
import isa.projekat.projektniZadatak.repository.RefreshTokenRepository;
import isa.projekat.projektniZadatak.security.HashingAlogorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class RefreshTokenService {
    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    public UUID generateRefreshToken(UserApp userApp){
        UUID token = UUID.randomUUID();
        RefreshToken refreshToken = RefreshToken.builder()
                .id(UUID.randomUUID())
                .hmacValue(HashingAlogorithm.calculateHmac(token.toString()))
                .userApp(userApp)
                .dateTimeStart(LocalDateTime.now())
                .dateTimeEnd(LocalDateTime.now().plusDays(1))
                .build();
        refreshTokenRepository.save(refreshToken);
        return token;
    }

    public UserApp validateTokenAndGetUser(UUID token){
        RefreshToken refreshToken = refreshTokenRepository.findByHmacValue(HashingAlogorithm.calculateHmac(token.toString()));
        if(refreshToken == null || refreshToken.isExpired()){
            return null;
        }
        return refreshToken.getUserApp();
    }
}
