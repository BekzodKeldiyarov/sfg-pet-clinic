package com.bekzodkeldiyarov.springpetproject.repositories;

import com.bekzodkeldiyarov.springpetproject.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
