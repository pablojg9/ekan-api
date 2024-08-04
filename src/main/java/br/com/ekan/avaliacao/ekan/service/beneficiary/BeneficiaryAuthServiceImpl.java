package br.com.ekan.avaliacao.ekan.service.beneficiary;

import br.com.ekan.avaliacao.ekan.entity.beneficiary.Beneficiary;
import br.com.ekan.avaliacao.ekan.repository.beneficiary.BeneficiaryRepository;
import br.com.ekan.avaliacao.ekan.service.authentication.AuthService;
import br.com.ekan.avaliacao.ekan.service.authentication.BaseAuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BeneficiaryAuthServiceImpl extends BaseAuthService<Beneficiary> implements AuthService {

  private final BeneficiaryRepository beneficiaryRepository;

  public BeneficiaryAuthServiceImpl(PasswordEncoder passwordEncoder, BeneficiaryRepository beneficiaryRepository) {
    super(passwordEncoder);
    this.beneficiaryRepository = beneficiaryRepository;
  }

  @Override
  protected Optional<Beneficiary> findUserByUsername(String username) {
    return beneficiaryRepository.findByUsername(username);
  }

  @Override
  protected String getPassword(Beneficiary user) {
    return user.getPassword();
  }
}
