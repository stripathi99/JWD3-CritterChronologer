package com.udacity.jdnd.course3.critter.controller;

import com.udacity.jdnd.course3.critter.dto.PetDTO;
import com.udacity.jdnd.course3.critter.mapper.PetDTOMapper;
import com.udacity.jdnd.course3.critter.service.PetService;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @Autowired
    private PetDTOMapper petDTOMapper;

    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
        return petDTOMapper.petToPetDTO(petService.save(petDTOMapper.petDTOToPet(petDTO)));
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        return petDTOMapper.petToPetDTO(petService.getPetBy(petId));
    }

    @GetMapping
    public List<PetDTO> getPets() {
        return petService.list()
            .stream()
            .map(petDTOMapper::petToPetDTO)
            .collect(Collectors.toList());
    }

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        return petService.getAllOwnerPets(ownerId)
            .stream()
            .map(petDTOMapper::petToPetDTO)
            .collect(Collectors.toList());
    }
}
