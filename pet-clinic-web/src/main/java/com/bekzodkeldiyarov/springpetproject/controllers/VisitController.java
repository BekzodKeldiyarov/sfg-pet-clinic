package com.bekzodkeldiyarov.springpetproject.controllers;

import com.bekzodkeldiyarov.springpetproject.model.Pet;
import com.bekzodkeldiyarov.springpetproject.model.Visit;
import com.bekzodkeldiyarov.springpetproject.services.OwnerService;
import com.bekzodkeldiyarov.springpetproject.services.PetService;
import com.bekzodkeldiyarov.springpetproject.services.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class VisitController {
    private final PetService petService;
    private final OwnerService ownerService;
    private final VisitService visitService;

    private final String VIEW_CREATE_OR_UPDATE_VISIT_FORM = "pets/createOrUpdateVisitForm";

    public VisitController(PetService petService, OwnerService ownerService, VisitService visitService) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.visitService = visitService;
    }

    @ModelAttribute("visit")
    public Visit loadPetWithVisit(@PathVariable("petID") Long petID, Model model) {
        Pet pet = petService.findById(petID);
        model.addAttribute("pet", pet);
        Visit visit = new Visit();
        pet.getVisits().add(visit);
        visit.setPet(pet);
        return visit;
    }

    @GetMapping("/owners/*/pets/{petID}/visits/new")
    public String initNewVisitForm(@PathVariable("petID") Long petID, Model model) {

        return VIEW_CREATE_OR_UPDATE_VISIT_FORM;
    }

    @PostMapping("/owners/{ownerID}/pets/{petID}/visits/new")
    public String processNewVisitForm(@Valid Visit visit, BindingResult result) {
        if (result.hasErrors()) {
            return VIEW_CREATE_OR_UPDATE_VISIT_FORM;
        } else {
            visitService.save(visit);
            return "redirect:/owners/{ownerID}";
        }
    }
}
