package br.com.ekan.avaliacao.ekan.service;

import javax.validation.Valid;
import java.util.List;

public interface CrudService<T, Z, ID> {

  List<T> findAll();

  T findById(ID id);

  T save(@Valid Z t);

  T update(ID id, @Valid Z t);

  void delete(ID id);
}
