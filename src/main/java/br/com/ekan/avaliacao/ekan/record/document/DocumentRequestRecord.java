package br.com.ekan.avaliacao.ekan.record.document;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;

public record DocumentRequestRecord(

  @Schema(name = "tipoDocumento")
  @JsonProperty("tipoDocumento")
  @NotNull(message = "type document cannot be not null")
  Integer typeDocument,

  @Schema(name = "descricao")
  @JsonProperty("descricao")
  String description
) {
}
