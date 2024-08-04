package br.com.ekan.avaliacao.ekan.repository.document;

import br.com.ekan.avaliacao.ekan.entity.document.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DocumentRepository extends JpaRepository<Document, UUID> {

  List<Document> findByTypeDocument(Integer typeDocument);
}
