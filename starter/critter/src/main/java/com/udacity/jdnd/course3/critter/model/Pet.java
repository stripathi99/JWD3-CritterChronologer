package com.udacity.jdnd.course3.critter.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Pet extends User {

  private PetType type;

  @ManyToOne
  private Customer owner;

  private LocalDate birthDate;
  private String notes;

  public PetType getType() {
    return type;
  }

  public void setType(PetType type) {
    this.type = type;
  }

  public Customer getOwner() {
    return owner;
  }

  public void setOwner(Customer owner) {
    this.owner = owner;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }
}