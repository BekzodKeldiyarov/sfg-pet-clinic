package com.bekzodkeldiyarov.springpetproject.controllers;

import com.bekzodkeldiyarov.springpetproject.model.Owner;
import com.bekzodkeldiyarov.springpetproject.services.OwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RequestMapping("/owners")
@Controller
@Slf4j
public class OwnerController {
    private final OwnerService ownerService;
    private final String VIEW_CREATE_OR_UPDATE_OWNER_FORM = "owners/createOrUpdateOwnerForm";

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }


    @GetMapping("/find")
    public String findOwners(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }


    @GetMapping("/{ownerID}")
    public ModelAndView showOwner(@PathVariable("ownerID") Long ownerID) {
        ModelAndView modelAndView = new ModelAndView("owners/ownerDetails");
        modelAndView.addObject(ownerService.findById(ownerID));

        return modelAndView;
    }

    @GetMapping({"/", ""})
    public String processFindForm(Owner owner, BindingResult result, Model model) {
        log.info("The last name of owner is :" + owner.getLastName());
        if (owner.getLastName() == null) {
            owner.setLastName("");
        }
        List<Owner> results = ownerService.findByLastNameLike("%" + owner.getLastName() + "%");
        if (results.isEmpty()) {
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        } else if (results.size() == 1) {
            owner = results.iterator().next();
            return "redirect:/owners/" + owner.getId();
        } else {
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }
    }

    @GetMapping("/new")
    public String initCreatingForm(Model model) {
        Owner owner = Owner.builder().build();
        model.addAttribute("owner", owner);
        return VIEW_CREATE_OR_UPDATE_OWNER_FORM;
    }

    @PostMapping("/new")
    public String processCreatingForm(@Valid Owner owner, BindingResult result) {
        if (result.hasErrors()) {
            return VIEW_CREATE_OR_UPDATE_OWNER_FORM;
        } else {
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }

    @GetMapping("/{ownerID}/edit")
    public String initUpdateForm(@PathVariable Long ownerID, Model model) {
        model.addAttribute("owner", ownerService.findById(ownerID));
        return VIEW_CREATE_OR_UPDATE_OWNER_FORM;
    }


    @PostMapping("/{ownerID}/edit")
    public String processUpdateForm(@Valid Owner owner, BindingResult result, @PathVariable Long ownerID) {
        if (result.hasErrors()) {
            return VIEW_CREATE_OR_UPDATE_OWNER_FORM;
        } else {
            owner.setId(ownerID);
            log.info(owner.getId() + "");
            Owner updatedOwner = ownerService.save(owner);
            return "redirect:/owners/" + updatedOwner.getId();
        }
    }

}
