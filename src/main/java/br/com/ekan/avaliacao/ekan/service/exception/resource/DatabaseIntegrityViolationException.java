package br.com.ekan.avaliacao.ekan.service.exception.resource;

public class DatabaseIntegrityViolationException extends RuntimeException {

  public DatabaseIntegrityViolationException() {
  }

  public DatabaseIntegrityViolationException(String message) {
    super(message);
  }

  public DatabaseIntegrityViolationException(String message, Throwable cause) {
    super(message, cause);
  }
}
