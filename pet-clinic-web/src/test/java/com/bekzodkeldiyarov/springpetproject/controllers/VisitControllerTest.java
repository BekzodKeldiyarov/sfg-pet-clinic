package com.bekzodkeldiyarov.springpetproject.controllers;

import com.bekzodkeldiyarov.springpetproject.services.OwnerService;
import com.bekzodkeldiyarov.springpetproject.services.PetService;
import com.bekzodkeldiyarov.springpetproject.services.VisitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;

class VisitControllerTest {

    @Mock
    OwnerService ownerService;
    @Mock
    PetService petService;
    @Mock
    VisitService visitService;

    VisitController controller;
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        controller = new VisitController(petService, ownerService, visitService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void loadPetWithVisit() {
    }

    @Test
    void initNewVisitForm() {

    }

    @Test
    void processNewVisitForm() {
    }
}