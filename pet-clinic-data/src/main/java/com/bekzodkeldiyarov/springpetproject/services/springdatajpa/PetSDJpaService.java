package com.bekzodkeldiyarov.springpetproject.services.springdatajpa;

import com.bekzodkeldiyarov.springpetproject.model.Pet;
import com.bekzodkeldiyarov.springpetproject.model.PetType;
import com.bekzodkeldiyarov.springpetproject.repositories.PetRepository;
import com.bekzodkeldiyarov.springpetproject.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {
    private final PetRepository petRepository;

    public PetSDJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long id) {
        Optional<Pet> petOptional = petRepository.findById(id);
        if (petOptional.isPresent()) {
            return petOptional.get();
        }
        return null;
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
