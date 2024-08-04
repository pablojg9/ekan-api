package br.com.ekan.avaliacao.ekan.service.exception.resource;

public class ResourceException extends RuntimeException {

  public ResourceException() {
  }

  public ResourceException(String message) {
    super(message);
  }

  public ResourceException(String message, Throwable cause) {
    super(message, cause);
  }
}
