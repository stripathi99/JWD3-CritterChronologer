package com.udacity.jdnd.course3.critter.mapper;

import static org.springframework.beans.BeanUtils.copyProperties;

import com.udacity.jdnd.course3.critter.dto.PetDTO;
import com.udacity.jdnd.course3.critter.model.Pet;
import org.springframework.stereotype.Component;

@Component
public class PetDTOMapper {

  public Pet petDTOToPet(PetDTO petDTO) {
    Pet pet = new Pet();
    copyProperties(petDTO, pet);
    return pet;
  }

  public PetDTO petToPetDTO(Pet pet) {
    PetDTO petDTO = new PetDTO();
    copyProperties(pet, petDTO);
    petDTO.setOwnerId(pet.getOwner().getId());
    return petDTO;
  }
}
