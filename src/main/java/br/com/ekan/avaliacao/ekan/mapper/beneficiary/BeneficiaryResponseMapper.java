package br.com.ekan.avaliacao.ekan.mapper.beneficiary;

import br.com.ekan.avaliacao.ekan.config.mapper.MapperConfiguration;
import br.com.ekan.avaliacao.ekan.entity.beneficiary.Beneficiary;
import br.com.ekan.avaliacao.ekan.record.beneficiary.BeneficiaryResponseRecord;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface BeneficiaryResponseMapper {

  BeneficiaryResponseRecord entityToDto(Beneficiary beneficiary);

  Beneficiary dtoToEntity(BeneficiaryResponseRecord beneficiaryResponseRecord);
}
