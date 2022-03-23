package com.bekzodkeldiyarov.springpetproject.model;

public class Specialty extends BaseEntity {
    private String description;

    public Specialty(String description) {
        this.description = description;
    }
}
