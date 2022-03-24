package com.bekzodkeldiyarov.springpetproject.repositories;

import com.bekzodkeldiyarov.springpetproject.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastname);
}
