package br.com.ekan.avaliacao.ekan.record.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthResponseRecord(
  @JsonProperty("access_token")
  String accessToken,

  @JsonProperty("expires_in")
  Long expiresIn) { }
