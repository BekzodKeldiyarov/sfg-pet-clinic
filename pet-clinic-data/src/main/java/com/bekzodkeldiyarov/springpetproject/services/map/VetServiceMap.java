package com.bekzodkeldiyarov.springpetproject.services.map;

import com.bekzodkeldiyarov.springpetproject.model.Vet;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long>{
    @Override
    Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    Vet save(Long id, Vet object) {
        return super.save(id, object);
    }

    @Override
    void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    void delete(Vet object) {
        super.delete(object);
    }
}
