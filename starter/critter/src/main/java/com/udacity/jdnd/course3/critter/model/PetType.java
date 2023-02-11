package com.udacity.jdnd.course3.critter.model;

/**
 * An example list of pet type metadata that could be included on a request to create a pet.
 */
public enum PetType {
    CAT ("CAT"),
    DOG ("DOG"),
    LIZARD ("LIZARD"),
    BIRD ("BIRD"),
    FISH ("FISH"),
    SNAKE ("SNAKE"),
    OTHER ("OTHER");

    private final String petType;

    PetType(String petType) {
        this.petType = petType;
    }
}
