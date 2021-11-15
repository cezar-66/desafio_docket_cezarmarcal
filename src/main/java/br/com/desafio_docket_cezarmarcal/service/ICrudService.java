package br.com.desafio_docket_cezarmarcal.service;

import java.util.Set;

public interface ICrudService<T, ID> {
    Set<T> getAll();

    T findById(ID id);

    Long create(T tDetails);

    void update(ID id, T tDetails);

    void delete(ID id);
}
