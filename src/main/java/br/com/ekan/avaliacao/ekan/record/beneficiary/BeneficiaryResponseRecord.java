package br.com.ekan.avaliacao.ekan.record.beneficiary;

import br.com.ekan.avaliacao.ekan.record.document.DocumentResponseRecord;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record BeneficiaryResponseRecord(

  UUID id,

  @Schema(name = "username")
  String username,

  @Schema(name = "username")
  @JsonProperty("senha")
  String password,

  @Schema(name = "nome")
  @JsonProperty("nome")
  String name,

  @Schema(name = "telefone")
  @JsonProperty("telefone")
  String telephone,


  @Schema(name = "dataNascimento")
  @JsonProperty("dataNascimento")
  String dateBirth,

  @Schema(name = "dataInclusao")
  @JsonProperty("dataInclusao")
  LocalDateTime dateInclusion,

  @Schema(name = "dataAtualizacao")
  @JsonProperty("dataAtualizacao")
  LocalDateTime updatedAt,

  @Schema(name = "documentos")
  @JsonProperty("documentos")
  List<DocumentResponseRecord> documents
) {
}
