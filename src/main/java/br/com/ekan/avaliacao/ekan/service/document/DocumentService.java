package br.com.ekan.avaliacao.ekan.service.document;

import br.com.ekan.avaliacao.ekan.entity.document.Document;
import br.com.ekan.avaliacao.ekan.record.document.DocumentRequestRecord;
import br.com.ekan.avaliacao.ekan.record.document.DocumentResponseRecord;
import br.com.ekan.avaliacao.ekan.service.CrudService;
import org.mapstruct.Named;

import java.util.List;
import java.util.UUID;

public interface DocumentService extends CrudService<DocumentResponseRecord, DocumentRequestRecord, UUID> {

  @Named("findByTypeDocument")
  List<Document> findByTypeDocument(Integer typeDocument);

}
