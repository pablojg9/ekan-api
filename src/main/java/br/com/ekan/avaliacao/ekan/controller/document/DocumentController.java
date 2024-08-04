package br.com.ekan.avaliacao.ekan.controller.document;

import br.com.ekan.avaliacao.ekan.controller.CrudController;
import br.com.ekan.avaliacao.ekan.record.document.DocumentRequestRecord;
import br.com.ekan.avaliacao.ekan.record.document.DocumentResponseRecord;
import br.com.ekan.avaliacao.ekan.service.CrudService;
import br.com.ekan.avaliacao.ekan.service.document.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/documents")
@RequiredArgsConstructor
public class DocumentController extends CrudController<DocumentResponseRecord, DocumentRequestRecord, UUID> {

  private final DocumentService documentService;

  @Override
  protected CrudService<DocumentResponseRecord, DocumentRequestRecord, UUID> getService() {
    return documentService;
  }
}
