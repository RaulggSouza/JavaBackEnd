package br.ifsp.infection.persistence;

import java.util.List;

public interface BulletinDAO <T, K>{
    void insert(T entity);
    void delete(K key);
    void update(T entity);
    boolean existsById(K key);
    List<T> findAll();
}
