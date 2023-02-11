package com.udacity.jdnd.course3.critter.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.Nationalized;

@MappedSuperclass
public abstract class User {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  @Nationalized
  private String name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}