package br.com.ekan.avaliacao.ekan.service.authentication;

import br.com.ekan.avaliacao.ekan.record.authentication.AuthRequestRecord;
import br.com.ekan.avaliacao.ekan.record.authentication.AuthResponseRecord;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class BaseAuthService<T> {

  @Value("${security.token.secret}")
  private String secretKey;

  protected abstract Optional<T> findUserByUsername(String username);

  protected abstract String getPassword(T user);

  private final PasswordEncoder passwordEncoder;

  public AuthResponseRecord authenticate(AuthRequestRecord authRequestRecord) {

    T user = findUserByUsername(authRequestRecord.username()).orElseThrow(() -> new UsernameNotFoundException("User name was not found"));

    if (!passwordEncoder.matches(authRequestRecord.password(), getPassword(user)))
      throw new BadCredentialsException("Wrong password");

    Algorithm algorithm = Algorithm.HMAC256(secretKey);
    Instant expiresIn = Instant.now().plus(Duration.ofHours(2));

    String token = JWT.create().withIssuer("ekan")
      .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
      .withExpiresAt(expiresIn)
      .withClaim("roles", List.of("USER"))
      .sign(algorithm);

    return new AuthResponseRecord(token, expiresIn.getEpochSecond());
  }

}
