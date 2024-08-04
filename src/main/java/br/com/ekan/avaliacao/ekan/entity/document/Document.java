package br.com.ekan.avaliacao.ekan.entity.document;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "DOCUMENTO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Document {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "TIPO_DOCUMENTO")
  private Integer typeDocument;

  @Column(name = "DESCRICAO")
  private String description;

  @Column(name = "DATA_INCLUSAO")
  @CreationTimestamp
  private LocalDateTime dateInclusion;

  @Column(name = "DATA_ATUALIZACAO")
  @UpdateTimestamp
  private LocalDateTime updatedAt;
}
