package com.bekzodkeldiyarov.springpetproject.services.map;

import com.bekzodkeldiyarov.springpetproject.model.Pet;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet, Long>{
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Long id, Pet object) {
        return super.save(id, object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }
}
