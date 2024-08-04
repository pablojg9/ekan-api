package br.com.ekan.avaliacao.ekan.service.beneficiary;

import br.com.ekan.avaliacao.ekan.entity.beneficiary.Beneficiary;
import br.com.ekan.avaliacao.ekan.mapper.beneficiary.BeneficiaryRequestMapper;
import br.com.ekan.avaliacao.ekan.mapper.beneficiary.BeneficiaryResponseMapper;
import br.com.ekan.avaliacao.ekan.record.beneficiary.BeneficiaryRequestRecord;
import br.com.ekan.avaliacao.ekan.record.beneficiary.BeneficiaryResponseRecord;
import br.com.ekan.avaliacao.ekan.repository.beneficiary.BeneficiaryRepository;
import br.com.ekan.avaliacao.ekan.service.exception.resource.DatabaseIntegrityViolationException;
import br.com.ekan.avaliacao.ekan.service.exception.resource.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class BeneficiaryServiceImpl implements BeneficiaryService {

  private final BeneficiaryRepository beneficiaryRepository;
  private final BeneficiaryResponseMapper beneficiaryResponseMapper;
  private final BeneficiaryRequestMapper beneficiaryRequestMapper;
  private static Set<BeneficiaryResponseRecord> beneficiarys;

  private void checkAndSaveToMemory() {
    if (isNull(beneficiarys) || beneficiarys.isEmpty()) {
      beneficiarys = beneficiaryRepository
        .findAll()
        .stream()
        .map(beneficiaryResponseMapper::entityToDto)
        .collect(Collectors.toSet());
    }
  }

  private void refresh() {
    beneficiarys = beneficiaryRepository
      .findAll()
      .stream()
      .map(beneficiaryResponseMapper::entityToDto)
      .collect(Collectors.toSet());
  }


  @Override
  public List<BeneficiaryResponseRecord> findAll() {
    checkAndSaveToMemory();
    if (beneficiarys.isEmpty()) return Collections.emptyList();

    return new ArrayList<>(beneficiarys);
  }

  @Override
  public BeneficiaryResponseRecord findById(UUID uuid) {
    checkAndSaveToMemory();
    return beneficiarys
      .stream()
      .filter(c -> c.id().equals(uuid))
      .findFirst()
      .orElseThrow(() -> new UsernameNotFoundException("Beneficiary not found with id " + uuid));
  }

  @Override
  public BeneficiaryResponseRecord save(BeneficiaryRequestRecord dto) {

    try {
      Beneficiary beneficiary = beneficiaryRequestMapper.dtoToEntity(dto);
      beneficiaryRepository.save(beneficiary);

      refresh();
      return beneficiaryResponseMapper.entityToDto(beneficiary);

    } catch (DatabaseIntegrityViolationException e) {
      throw new DatabaseIntegrityViolationException("Integration violation");
    }
  }

  @Override
  public BeneficiaryResponseRecord update(UUID uuid, BeneficiaryRequestRecord beneficiaryRequestRecord) {
    if (!beneficiaryRepository.existsById(uuid))
      throw new ResourceNotFoundException("Beneficiary not found with id " + uuid);

    Beneficiary beneficiary = beneficiaryRequestMapper.dtoToEntity(beneficiaryRequestRecord);
    beneficiary.setId(uuid);
    beneficiaryRepository.save(beneficiary);
    refresh();

    return beneficiaryResponseMapper.entityToDto(beneficiary);
  }

  @Override
  public void delete(UUID uuid) {
    try {
      if (!beneficiaryRepository.existsById(uuid)) throw new ResourceNotFoundException("Beneficiary not found with id " + uuid);

      beneficiaryRepository.deleteById(uuid);
      refresh();
    } catch (DatabaseIntegrityViolationException e) {
      throw new DatabaseIntegrityViolationException("Integrity Violation");
    }

  }
}
