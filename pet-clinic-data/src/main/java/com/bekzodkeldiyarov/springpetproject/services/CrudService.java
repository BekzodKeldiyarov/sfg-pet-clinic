package com.bekzodkeldiyarov.springpetproject.services;

import com.bekzodkeldiyarov.springpetproject.model.Owner;

import java.util.Set;

public interface CrudService<T, ID> {
    T findByLastId(ID id);

    T findByLastName(String lastName);

    T save(T object);

    Set<T> findAll();

    void delete(T object);

    void deleteById(ID id);
}
