package com.bekzodkeldiyarov.springpetproject.services.springdatajpa;

import com.bekzodkeldiyarov.springpetproject.model.PetType;
import com.bekzodkeldiyarov.springpetproject.repositories.PetTypeRepository;
import com.bekzodkeldiyarov.springpetproject.services.PetTypeService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class PetTypeSDJpaService implements PetTypeService {
    private final PetTypeRepository petTypeRepository;

    public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return null;
    }

    @Override
    public PetType findById(Long id) {
        Optional<PetType> petTypeOptional = petTypeRepository.findById(id);
        if (petTypeOptional.isPresent()) {
            return petTypeOptional.get();
        }
        return null;
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepository.deleteById(id);
    }
}
