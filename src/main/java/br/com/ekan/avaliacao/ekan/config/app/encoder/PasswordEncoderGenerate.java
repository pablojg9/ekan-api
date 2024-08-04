package br.com.ekan.avaliacao.ekan.config.app.encoder;

import org.mapstruct.Named;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class PasswordEncoderGenerate {

  private final PasswordEncoder passwordEncoder;

  public PasswordEncoderGenerate(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  @Named("encode")
  public String encode(String password) {
    return passwordEncoder.encode(password);
  }
}
