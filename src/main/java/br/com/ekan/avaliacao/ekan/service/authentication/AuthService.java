package br.com.ekan.avaliacao.ekan.service.authentication;

import br.com.ekan.avaliacao.ekan.record.authentication.AuthRequestRecord;
import br.com.ekan.avaliacao.ekan.record.authentication.AuthResponseRecord;

public interface AuthService {

  AuthResponseRecord authenticate(AuthRequestRecord authRequestRecord);

}
