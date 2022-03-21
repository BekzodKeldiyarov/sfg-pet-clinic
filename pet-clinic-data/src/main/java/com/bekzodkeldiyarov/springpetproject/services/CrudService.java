package com.bekzodkeldiyarov.springpetproject.services;

import com.bekzodkeldiyarov.springpetproject.model.Owner;
import com.bekzodkeldiyarov.springpetproject.services.map.AbstractMapService;

import java.util.Set;

public interface CrudService<T, ID> {

    T findByLastName(String lastName);

    T save(T object);

    Set<T> findAll();

    void delete(T object);

    void deleteById(ID id);
}
