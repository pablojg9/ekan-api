package br.com.ekan.avaliacao.ekan.service.document;

import br.com.ekan.avaliacao.ekan.mapper.document.DocumentResponseMapper;
import br.com.ekan.avaliacao.ekan.record.document.DocumentResponseRecord;
import br.com.ekan.avaliacao.ekan.repository.document.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class DocumentCacheServiceImpl implements DocumentCacheService {

  private final DocumentRepository documentRepository;
  private final DocumentResponseMapper documentResponseMapper;

  private Set<DocumentResponseRecord> documents;

  @Override
  public void checkAndSaveToMemory() {
    if (isNull(documents) || documents.isEmpty()) {
      documents = documentRepository
        .findAll()
        .stream()
        .map(documentResponseMapper::entityToDto)
        .collect(Collectors.toSet());
    }
  }

  @Override
  public void refresh() {
    documents = documentRepository
      .findAll()
      .stream()
      .map(documentResponseMapper::entityToDto)
      .collect(Collectors.toSet());
  }

  @Override
  public List<DocumentResponseRecord> getAllDocuments() {
    if (isNull(documents) || documents.isEmpty()) refresh();
    return new ArrayList<>(documents);
  }

}
