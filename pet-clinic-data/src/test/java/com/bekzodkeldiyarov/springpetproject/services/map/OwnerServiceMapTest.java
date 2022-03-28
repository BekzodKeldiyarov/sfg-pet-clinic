package com.bekzodkeldiyarov.springpetproject.services.map;

import com.bekzodkeldiyarov.springpetproject.model.Owner;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class OwnerServiceMapTest {
    OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().firstName("Bek").lastName("Keldi").build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();

        assertEquals(1, owners.size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(1L);
        log.info("ID is:" + owner.getId());
        assertEquals(1L, owner.getId());
    }

    @Test
    void saveExistingId() {
        Owner owner2 = Owner.builder().firstName("Test").build();
        owner2.setId(1L);
        Owner savedOwner = ownerServiceMap.save(owner2);
        log.info("ID of saved is " + savedOwner.getId());
        assertEquals(1L, savedOwner.getId());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(1L);
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {

    }

    @Test
    void findByLastName() {
        Owner foundOwner = ownerServiceMap.findByLastName("keldi");
        log.info(foundOwner.getLastName());
        assertNotNull(foundOwner);
        assertEquals("Keldi", foundOwner.getLastName());
    }

    @Test
    void findByLastNameNotNull() {
        Owner foundOwner = ownerServiceMap.findByLastName("foo");

        assertNull(foundOwner);

    }
}