package com.bekzodkeldiyarov.springpetproject.services;

import com.bekzodkeldiyarov.springpetproject.model.Owner;
import com.bekzodkeldiyarov.springpetproject.services.map.AbstractMapService;

import java.util.Set;

public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
