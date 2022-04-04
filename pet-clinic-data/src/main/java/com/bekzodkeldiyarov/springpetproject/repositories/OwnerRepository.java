package com.bekzodkeldiyarov.springpetproject.repositories;

import com.bekzodkeldiyarov.springpetproject.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastname);

    List<Owner> findByLastNameLike(String lastname);
}
