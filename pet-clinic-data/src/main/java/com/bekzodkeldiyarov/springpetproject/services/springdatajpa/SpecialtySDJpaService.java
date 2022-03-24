package com.bekzodkeldiyarov.springpetproject.services.springdatajpa;

import com.bekzodkeldiyarov.springpetproject.model.PetType;
import com.bekzodkeldiyarov.springpetproject.model.Specialty;
import com.bekzodkeldiyarov.springpetproject.repositories.SpecialtyRepository;
import com.bekzodkeldiyarov.springpetproject.services.SpecialtyService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class SpecialtySDJpaService implements SpecialtyService {
    private final SpecialtyRepository specialtyRepository;

    public SpecialtySDJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long id) {
        Optional<Specialty> specialtyOptional = specialtyRepository.findById(id);
        if (specialtyOptional.isPresent()) {
            return specialtyOptional.get();
        }
        return null;
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Specialty object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);
    }
}
