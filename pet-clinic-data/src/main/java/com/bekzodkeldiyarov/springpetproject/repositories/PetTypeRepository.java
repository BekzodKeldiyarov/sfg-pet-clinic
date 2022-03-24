package com.bekzodkeldiyarov.springpetproject.repositories;

import com.bekzodkeldiyarov.springpetproject.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
