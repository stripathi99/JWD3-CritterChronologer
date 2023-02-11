package com.udacity.jdnd.course3.critter.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Customer extends User {

  private String phoneNumber;
  private String notes;

  @OneToMany(mappedBy = "owner")
  private List<Pet> pets;

  public Customer(String phoneNumber, String notes, List<Pet> pets) {
    this.phoneNumber = phoneNumber;
    this.notes = notes;
    this.pets = pets;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public List<Pet> getPets() {
    return pets;
  }

  public void setPets(List<Pet> pets) {
    this.pets = pets;
  }
}
