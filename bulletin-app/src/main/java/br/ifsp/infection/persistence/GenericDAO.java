package br.ifsp.infection.persistence;

import java.util.List;

public interface GenericDAO<T, K>{
    void insert(T t);
    void delete(K k);
    void update(T t);
    boolean existsById(K k);
    List<T> findAll(String condition);
}
