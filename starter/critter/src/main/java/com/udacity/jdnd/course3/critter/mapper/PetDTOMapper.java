package com.udacity.jdnd.course3.critter.mapper;

import static org.springframework.beans.BeanUtils.copyProperties;

import com.udacity.jdnd.course3.critter.dto.PetDTO;
import com.udacity.jdnd.course3.critter.model.Pet;
import com.udacity.jdnd.course3.critter.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetDTOMapper {

  @Autowired
  private CustomerService customerService;

  public Pet petDTOToPet(PetDTO petDTO) {
    Pet pet = new Pet();
    copyProperties(petDTO, pet);
    pet.setOwner(customerService.getCustomer(petDTO.getOwnerId()));
    return pet;
  }

  public PetDTO petToPetDTO(Pet pet) {
    PetDTO petDTO = new PetDTO();
    copyProperties(pet, petDTO);
    petDTO.setOwnerId(pet.getOwner().getId());
    return petDTO;
  }
}
