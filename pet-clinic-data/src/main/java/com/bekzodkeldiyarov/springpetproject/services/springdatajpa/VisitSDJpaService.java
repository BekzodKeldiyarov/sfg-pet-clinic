package com.bekzodkeldiyarov.springpetproject.services.springdatajpa;

import com.bekzodkeldiyarov.springpetproject.model.Visit;
import com.bekzodkeldiyarov.springpetproject.repositories.VisitRepository;
import com.bekzodkeldiyarov.springpetproject.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {
    private final VisitRepository visitRepository;

    public VisitSDJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long id) {
        Optional<Visit> visitOptional = visitRepository.findById(id);
        if (visitOptional.isPresent()) {
            return visitOptional.get();
        }
        return null;
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }
}
