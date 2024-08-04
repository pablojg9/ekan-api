package br.com.ekan.avaliacao.ekan.service.document;

import br.com.ekan.avaliacao.ekan.record.document.DocumentResponseRecord;

import java.util.List;

public interface DocumentCacheService {

  void checkAndSaveToMemory();

  void refresh();

  List<DocumentResponseRecord> getAllDocuments();

}
