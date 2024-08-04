package br.com.ekan.avaliacao.ekan.record.document;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record DocumentResponseRecord(

  @Schema(name = "tipoDocumento")
  @JsonProperty("tipoDocumento")
  Integer typeDocument,

  @Schema(name = "descricao")
  @JsonProperty("descricao")
  String description,

  @Schema(name = "dataInclusao")
  @JsonProperty("dataInclusao")
  LocalDateTime dateInclusion,

  @Schema(name = "dataAtualizacao")
  @JsonProperty("dataAtualizacao")
  LocalDateTime updatedAt
) {
}
