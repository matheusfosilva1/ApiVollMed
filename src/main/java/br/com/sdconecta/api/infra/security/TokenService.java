package br.com.sdconecta.api.infra.security;

import br.com.sdconecta.api.domain.model.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String getToken(User user) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API-Mathleus")
                    .withSubject(user.getLogin())
                    .withExpiresAt(dateExpiration())
                    .sign(algoritmo);
        } catch (JWTCreationException exception) {
           throw new RuntimeException("erro ao gerar token: ", exception);
        }
    }

    public String getSubject(String token){
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer("API-Mathleus")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTCreationException exception) {
            throw new RuntimeException("token inválido", exception);
        }
    }

    private Instant dateExpiration() {
        return LocalDateTime.now().plusHours(3).toInstant(ZoneOffset.of("-03:00"));
    }

}
