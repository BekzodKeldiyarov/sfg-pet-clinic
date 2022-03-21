package com.bekzodkeldiyarov.springpetproject.services;

import com.bekzodkeldiyarov.springpetproject.model.Owner;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface OwnerService {
    Owner findByLastId(Long id);

    Owner findByLastName(String lastName);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
