package com.bekzodkeldiyarov.springpetproject.services;

import com.bekzodkeldiyarov.springpetproject.model.Pet;

import java.util.Set;


public interface PetService {
    Pet findByLastId(Long id);

    Pet save(Pet owner);

    Set<Pet> findAll();
}
