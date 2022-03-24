package com.bekzodkeldiyarov.springpetproject.services.springdatajpa;

import com.bekzodkeldiyarov.springpetproject.model.Vet;
import com.bekzodkeldiyarov.springpetproject.repositories.VetRepository;
import com.bekzodkeldiyarov.springpetproject.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {
    private final VetRepository vetRepository;

    public VetSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long id) {
        Optional<Vet> vetOptional = vetRepository.findById(id);
        if (vetOptional.isPresent()) {
            return vetOptional.get();
        }
        return null;
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
