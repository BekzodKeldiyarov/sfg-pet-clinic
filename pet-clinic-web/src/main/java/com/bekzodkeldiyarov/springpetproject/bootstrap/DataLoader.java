package com.bekzodkeldiyarov.springpetproject.bootstrap;

import com.bekzodkeldiyarov.springpetproject.model.Owner;
import com.bekzodkeldiyarov.springpetproject.model.Pet;
import com.bekzodkeldiyarov.springpetproject.model.PetType;
import com.bekzodkeldiyarov.springpetproject.model.Vet;
import com.bekzodkeldiyarov.springpetproject.services.OwnerService;
import com.bekzodkeldiyarov.springpetproject.services.PetTypeService;
import com.bekzodkeldiyarov.springpetproject.services.VetService;
import com.bekzodkeldiyarov.springpetproject.services.map.OwnerServiceMap;
import com.bekzodkeldiyarov.springpetproject.services.map.PetTypeServiceMap;
import com.bekzodkeldiyarov.springpetproject.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Zarafshon");
        owner1.setCity("Zarafshon");
        owner1.setTelephone("+990999");




        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");

        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Zarafshon");
        owner2.setCity("Zarafshon");
        owner2.setTelephone("+990999");

        Pet fionasCat = new Pet();
        fionasCat.setName("Just cat");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(savedCatType);

        owner2.getPets().add(fionasCat);
        ownerService.save(owner2);

        System.out.println("Owners loaded...");

        Vet vet = new Vet();
        vet.setFirstName("Whiskey");
        vet.setLastName("K");

        vetService.save(vet);
        System.out.println("Vets loaded...");


    }
}
