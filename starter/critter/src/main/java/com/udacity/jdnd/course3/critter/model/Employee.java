package com.udacity.jdnd.course3.critter.model;

import static javax.persistence.EnumType.STRING;

import java.time.DayOfWeek;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

@Entity
public class Employee extends User {

  @ElementCollection(targetClass = EmployeeSkill.class)
  @Enumerated(STRING)
  private Set<EmployeeSkill> skills;

  @ElementCollection(targetClass = DayOfWeek.class)
  @Enumerated(STRING)
  private Set<DayOfWeek> daysAvailable;

  public Employee(Set<EmployeeSkill> skills, Set<DayOfWeek> daysAvailable) {
    this.skills = skills;
    this.daysAvailable = daysAvailable;
  }

  public Employee() {

  }

  public Set<EmployeeSkill> getSkills() {
    return skills;
  }

  public void setSkills(Set<EmployeeSkill> skills) {
    this.skills = skills;
  }

  public Set<DayOfWeek> getDaysAvailable() {
    return daysAvailable;
  }

  public void setDaysAvailable(Set<DayOfWeek> daysAvailable) {
    this.daysAvailable = daysAvailable;
  }
}
