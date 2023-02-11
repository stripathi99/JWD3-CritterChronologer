package com.udacity.jdnd.course3.critter.service;

import static java.util.Collections.singletonList;

import com.udacity.jdnd.course3.critter.model.Pet;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PetService {

  @Autowired
  private CustomerService customerService;

  @Autowired
  private PetRepository petRepository;

  public Pet save(Pet pet) {
    Pet savedPet = petRepository.save(pet);
    savedPet.getOwner().setPets(singletonList(savedPet));
    return savedPet;
  }

  public List<Pet> list() {
    return petRepository.findAll();
  }

  public Pet getPetBy(Long id) {
    return petRepository.getOne(id);
  }

  public List<Pet> getAllOwnerPets(Long ownerId) {
    return petRepository.findAllByOwnerId(ownerId);
  }
}
