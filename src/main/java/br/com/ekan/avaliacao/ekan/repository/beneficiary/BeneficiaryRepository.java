package br.com.ekan.avaliacao.ekan.repository.beneficiary;

import br.com.ekan.avaliacao.ekan.entity.beneficiary.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary, UUID> {

  Optional<Beneficiary> findByUsername(String username);

}
