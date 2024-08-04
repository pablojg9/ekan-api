package br.com.ekan.avaliacao.ekan.service.exception.resource;

public class ResourceInvalidException extends RuntimeException {

  public ResourceInvalidException() {
  }

  public ResourceInvalidException(String message) {
    super(message);
  }

  public ResourceInvalidException(String message, Throwable cause) {
    super(message, cause);
  }
}
