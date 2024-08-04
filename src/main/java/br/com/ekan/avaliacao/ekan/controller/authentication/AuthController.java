package br.com.ekan.avaliacao.ekan.controller.authentication;

import br.com.ekan.avaliacao.ekan.record.authentication.AuthRequestRecord;
import br.com.ekan.avaliacao.ekan.service.authentication.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authBeneficiaryService;

  @PostMapping
  protected ResponseEntity<Object> createAuthenticate(@RequestBody AuthRequestRecord authRequestRecord) {
    return ResponseEntity.status(HttpStatus.CREATED).body(authBeneficiaryService.authenticate(authRequestRecord));
  }

}
