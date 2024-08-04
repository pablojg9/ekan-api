package br.com.ekan.avaliacao.ekan.mapper.document;

import br.com.ekan.avaliacao.ekan.config.mapper.MapperConfiguration;
import br.com.ekan.avaliacao.ekan.entity.document.Document;
import br.com.ekan.avaliacao.ekan.record.document.DocumentRequestRecord;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface DocumentRequestMapper {

  DocumentRequestRecord entityToDto(Document document);

  Document dtoToEntity(DocumentRequestRecord documentRequestRecord);
}
