package com.udacity.jdnd.course3.critter.model;

/**
 * An example list of employee skills that could be included on an employee or a schedule request.
 */
public enum EmployeeSkill {
  PETTING ("PETTING"),
  WALKING ("WALKING"),
  FEEDING ("FEEDING"),
  MEDICATING ("MEDICATING"),
  SHAVING ("SHAVING");

  private final String skill;

  EmployeeSkill(String skill) {
    this.skill = skill;
  }
}
