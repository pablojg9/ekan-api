package br.com.ekan.avaliacao.ekan.controller.exception.record;

import java.time.Instant;
import java.util.Collection;

public record StandardErrorRecord(
  Instant timestamp,
  Integer status,
  Collection<String> errors,
  String path
) {}
