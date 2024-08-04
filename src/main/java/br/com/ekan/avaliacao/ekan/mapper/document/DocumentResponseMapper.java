package br.com.ekan.avaliacao.ekan.mapper.document;

import br.com.ekan.avaliacao.ekan.config.mapper.MapperConfiguration;
import br.com.ekan.avaliacao.ekan.entity.document.Document;
import br.com.ekan.avaliacao.ekan.record.document.DocumentResponseRecord;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface DocumentResponseMapper {

  DocumentResponseRecord entityToDto(Document document);
  Document dtoToEntity(DocumentResponseRecord documentResponseRecord);
}
