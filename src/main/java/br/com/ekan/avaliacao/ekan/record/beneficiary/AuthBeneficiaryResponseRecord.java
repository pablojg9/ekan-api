package br.com.ekan.avaliacao.ekan.record.beneficiary;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthBeneficiaryResponseRecord(

  @JsonProperty("access_token")
  String accessToken,

  @JsonProperty("expires_in")
  Long expiresIn
) {
}
