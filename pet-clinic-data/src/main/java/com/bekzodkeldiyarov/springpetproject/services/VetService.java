package com.bekzodkeldiyarov.springpetproject.services;

import com.bekzodkeldiyarov.springpetproject.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findByLastId(Long id);

    Vet findByLastName(String lastName);

    Vet save(Vet owner);

    Set<Vet> findAll();
}
