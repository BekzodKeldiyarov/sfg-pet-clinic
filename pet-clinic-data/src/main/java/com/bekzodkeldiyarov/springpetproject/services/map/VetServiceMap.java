package com.bekzodkeldiyarov.springpetproject.services.map;

import com.bekzodkeldiyarov.springpetproject.model.Vet;
import com.bekzodkeldiyarov.springpetproject.services.VetService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Long id, Vet object) {
        return super.save(id, object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet findByLastName(String lastName) {
        return null;
    }

    @Override
    public Vet save(Vet object) {
        return null;
    }
}
