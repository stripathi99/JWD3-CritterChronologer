package com.udacity.jdnd.course3.critter.model;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Schedule {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  @ManyToMany
  private List<Employee> employees;

  @ManyToMany
  private List<Pet> pets;

  private LocalDate date;

  @ElementCollection(targetClass = EmployeeSkill.class)
  @Enumerated(STRING)
  private Set<EmployeeSkill> activities;

  public Schedule(Long id, List<Employee> employees, List<Pet> pets, LocalDate date,
      Set<EmployeeSkill> activities) {
    this.id = id;
    this.employees = employees;
    this.pets = pets;
    this.date = date;
    this.activities = activities;
  }

  public Schedule() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }

  public List<Pet> getPets() {
    return pets;
  }

  public void setPets(List<Pet> pets) {
    this.pets = pets;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public Set<EmployeeSkill> getActivities() {
    return activities;
  }

  public void setActivities(Set<EmployeeSkill> activities) {
    this.activities = activities;
  }
}
