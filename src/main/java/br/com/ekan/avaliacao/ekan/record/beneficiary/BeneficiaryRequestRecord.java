package br.com.ekan.avaliacao.ekan.record.beneficiary;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record BeneficiaryRequestRecord(

  @NotNull
  @Schema(name = "username")
  String username,

  @NotNull
  @Schema(name = "senha")
  @JsonProperty("senha")
  String password,

  @Schema(name = "nome")
  @JsonProperty("nome")
  @NotBlank(message = "Name cannot be blank")
  String name,

  @Schema(name = "telefone")
  @JsonProperty("telefone")
  String telephone,

  @Schema(name = "dataNascimento")
  @JsonProperty("dataNascimento")
  @NotEmpty(message = "birth date cannot be empty")
  String dateBirth,

  @Schema(name = "tipoDocumento")
  @JsonProperty("tipoDocumento")
  Integer typeDocument
) {
}
