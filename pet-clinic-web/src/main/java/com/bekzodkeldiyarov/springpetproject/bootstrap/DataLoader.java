package com.bekzodkeldiyarov.springpetproject.bootstrap;

import com.bekzodkeldiyarov.springpetproject.model.Owner;
import com.bekzodkeldiyarov.springpetproject.model.Vet;
import com.bekzodkeldiyarov.springpetproject.services.OwnerService;
import com.bekzodkeldiyarov.springpetproject.services.VetService;
import com.bekzodkeldiyarov.springpetproject.services.map.OwnerServiceMap;
import com.bekzodkeldiyarov.springpetproject.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("Owners loaded...");

        Vet vet = new Vet();
        vet.setFirstName("Whiskey");
        vet.setLastName("K");

        vetService.save(vet);
        System.out.println("Vets loaded...");
    }
}
