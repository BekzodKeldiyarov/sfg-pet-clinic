package com.bekzodkeldiyarov.springpetproject.services.map;

import com.bekzodkeldiyarov.springpetproject.model.Pet;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet, Long>{
    @Override
    Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    Pet save(Long id, Pet object) {
        return super.save(id, object);
    }

    @Override
    void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    void delete(Pet object) {
        super.delete(object);
    }
}
