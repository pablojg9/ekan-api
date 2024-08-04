package br.com.ekan.avaliacao.ekan.providers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtProvider {

  @Value("${security.token.secret:DEFAULT}")
  private String secretkey;

  public DecodedJWT validateToken(String token) {
    token = token.replace("Bearer ", "");
    Algorithm algorithm = Algorithm.HMAC256(secretkey);

    try {
      return JWT.require(algorithm)
        .build()
        .verify(token);
    } catch (JWTVerificationException e) {
      e.printStackTrace();
      return null;
    }
  }
}
