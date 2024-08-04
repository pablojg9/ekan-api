package br.com.ekan.avaliacao.ekan.mapper.beneficiary;

import br.com.ekan.avaliacao.ekan.config.app.encoder.PasswordEncoderGenerate;
import br.com.ekan.avaliacao.ekan.config.mapper.MapperConfiguration;
import br.com.ekan.avaliacao.ekan.entity.beneficiary.Beneficiary;
import br.com.ekan.avaliacao.ekan.record.beneficiary.BeneficiaryRequestRecord;
import br.com.ekan.avaliacao.ekan.service.document.DocumentService;
import br.com.ekan.avaliacao.ekan.utils.localdatetime.LocalDateTimeUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfiguration.class,
  uses = {
    LocalDateTimeUtils.class,
    DocumentService.class,
    PasswordEncoderGenerate.class
  })
public interface BeneficiaryRequestMapper {

  BeneficiaryRequestRecord entityToDto(Beneficiary entity);

  @Mapping(target = "password", qualifiedByName = "encode", source = "password")
  @Mapping(target = "dateBirth", qualifiedByName = "convertDateStringToLocalDateTime", source = "dateBirth")
  @Mapping(target = "documents", qualifiedByName = "findByTypeDocument", source = "typeDocument")
  Beneficiary dtoToEntity(BeneficiaryRequestRecord dto);
}
