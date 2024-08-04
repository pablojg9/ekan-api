package br.com.ekan.avaliacao.ekan.controller;

import br.com.ekan.avaliacao.ekan.service.CrudService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public abstract class CrudController<T, Z, ID> {

  protected abstract CrudService<T, Z, ID> getService();

  @PreAuthorize("hasRole('USER')")
  @SecurityRequirement(name = "jwt_auth")
  @GetMapping
  public ResponseEntity<List<T>> findAll() {
    List<T> findAll = getService().findAll();
    return ResponseEntity.status(HttpStatus.OK).body(findAll);
  }

  @PostMapping("/save")
  public ResponseEntity<T> create(@Valid @RequestBody Z clazz) {
    T createdEntity = getService().save(clazz);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdEntity);
  }

  @PreAuthorize("hasRole('USER')")
  @SecurityRequirement(name = "jwt_auth")
  @GetMapping("{id}")
  public ResponseEntity<T> findById(@PathVariable ID id) {
    T entity = getService().findById(id);
    return ResponseEntity.status(HttpStatus.OK).body(entity);
  }

  @PreAuthorize("hasRole('USER')")
  @SecurityRequirement(name = "jwt_auth")
  @DeleteMapping("{id}")
  public ResponseEntity<Void> deleteById(@PathVariable ID id) {
    getService().delete(id);
    return ResponseEntity.noContent().build();
  }

  @PreAuthorize("hasRole('USER')")
  @SecurityRequirement(name = "jwt_auth")
  @PutMapping("{id}")
  public ResponseEntity<T> updateById(@PathVariable ID id, @Valid @RequestBody Z clazz) {
    T updatedEntity = getService().update(id, clazz);
    return ResponseEntity.status(HttpStatus.OK).body(updatedEntity);
  }

}
