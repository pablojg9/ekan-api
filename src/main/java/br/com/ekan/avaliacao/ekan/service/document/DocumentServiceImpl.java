package br.com.ekan.avaliacao.ekan.service.document;

import br.com.ekan.avaliacao.ekan.entity.document.Document;
import br.com.ekan.avaliacao.ekan.mapper.document.DocumentRequestMapper;
import br.com.ekan.avaliacao.ekan.mapper.document.DocumentResponseMapper;
import br.com.ekan.avaliacao.ekan.record.document.DocumentRequestRecord;
import br.com.ekan.avaliacao.ekan.record.document.DocumentResponseRecord;
import br.com.ekan.avaliacao.ekan.repository.document.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

  private final DocumentRepository documentRepository;
  private final DocumentResponseMapper documentResponseMapper;
  private final DocumentCacheService documentCacheService;
  private final DocumentRequestMapper documentRequestMapper;


  @Override
  public List<DocumentResponseRecord> findAll() {
    documentCacheService.checkAndSaveToMemory();
    return documentCacheService.getAllDocuments();
  }

  @Override
  public DocumentResponseRecord findById(UUID uuid) {
    return null;
  }

  @Override
  public DocumentResponseRecord save(DocumentRequestRecord t) {

    try {
      Document document = documentRequestMapper.dtoToEntity(t);
      documentRepository.save(document);
      documentCacheService.refresh();
      return documentResponseMapper.entityToDto(document);

    } catch (DataIntegrityViolationException e) {
      throw new DataIntegrityViolationException("Integration violation");
    }
  }

  @Override
  public DocumentResponseRecord update(UUID uuid, DocumentRequestRecord t) {
    return null;
  }

  @Override
  public void delete(UUID uuid) {

  }

  @Override
  public List<Document> findByTypeDocument(Integer typeDocument) {
    return documentRepository.findByTypeDocument(typeDocument);
  }
}
