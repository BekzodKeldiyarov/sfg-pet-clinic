package com.bekzodkeldiyarov.springpetproject.controllers;


import com.bekzodkeldiyarov.springpetproject.model.Owner;
import com.bekzodkeldiyarov.springpetproject.model.Pet;
import com.bekzodkeldiyarov.springpetproject.model.PetType;
import com.bekzodkeldiyarov.springpetproject.services.OwnerService;
import com.bekzodkeldiyarov.springpetproject.services.PetService;
import com.bekzodkeldiyarov.springpetproject.services.PetTypeService;
import org.mockito.internal.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Set;

@Controller
@RequestMapping("/owners/{ownerID}")
public class PetController {
    private final String VIEW_PET_CREATE_OR_UPDATE_PATH = "pets/createOrUpdatePetForm";

    private final PetService petService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;

    public PetController(PetService petService, OwnerService ownerService, PetTypeService petTypeService) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }

    @ModelAttribute("types")
    public Collection<PetType> popularPetTypes() {
        return this.petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerID") Long ownerID) {
        return ownerService.findById(ownerID);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/pets/new")
    public String initCreatingForm(@PathVariable Long ownerID, Model model) {
        Pet pet = new Pet();
        Owner owner = ownerService.findById(ownerID);
        owner.getPets().add(pet);
        pet.setOwner(owner);
        Set<PetType> petTypes = petTypeService.findAll();

        model.addAttribute("petTypes", petTypes);
        model.addAttribute("pet", pet);
        return VIEW_PET_CREATE_OR_UPDATE_PATH;
    }

    @PostMapping("/pets/new")
    public String processCreationForm(Owner owner, @Valid Pet pet, BindingResult result, Model model) {
        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null) {
            result.rejectValue("name", "duplicate", "already exists");
        }
        owner.getPets().add(pet);
        if (result.hasErrors()) {
            model.addAttribute("pet", pet);
            return VIEW_PET_CREATE_OR_UPDATE_PATH;
        } else {
            petService.save(pet);
        }
        return "redirect:/owners/" + owner.getId();
    }

    @GetMapping("/pets/{petID}/edit")
    public String initUpdateForm(@PathVariable Long petID, Model model) {
        model.addAttribute("pet", petService.findById(petID));

        return VIEW_PET_CREATE_OR_UPDATE_PATH;
    }

    @PostMapping("/pets/{petID}/edit")
    public String processUpdateForm(@Valid Pet pet, BindingResult result, Owner owner, Model model) {
        if (result.hasErrors()) {
            pet.setOwner(owner);
            model.addAttribute("pet", pet);
            return VIEW_PET_CREATE_OR_UPDATE_PATH;
        } else {
            owner.getPets().add(pet);
            petService.save(pet);
            return "redirect:/owners/" + owner.getId();
        }
    }
}
