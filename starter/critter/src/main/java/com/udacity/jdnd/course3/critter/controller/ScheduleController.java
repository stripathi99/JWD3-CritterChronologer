package com.udacity.jdnd.course3.critter.controller;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.udacity.jdnd.course3.critter.dto.ScheduleDTO;
import com.udacity.jdnd.course3.critter.mapper.ScheduleDTOMapper;
import com.udacity.jdnd.course3.critter.model.Schedule;
import com.udacity.jdnd.course3.critter.service.CustomerService;
import com.udacity.jdnd.course3.critter.service.EmployeeService;
import com.udacity.jdnd.course3.critter.service.PetService;
import com.udacity.jdnd.course3.critter.service.ScheduleService;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.server.ResponseStatusException;

/**
 * Handles web requests related to Schedules.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

  @Autowired
  private ScheduleService scheduleService;

  @Autowired
  private ScheduleDTOMapper scheduleDTOMapper;

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private PetService petService;

  @Autowired
  private CustomerService customerService;

  @PostMapping
  public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
    return scheduleDTOMapper.scheduleToScheduleDTO(
        scheduleService.saveSchedule(scheduleDTOMapper.scheduleDTOToSchedule(scheduleDTO)));
  }

  @GetMapping
  public List<ScheduleDTO> getAllSchedules() {
    return scheduleService
        .list()
        .stream()
        .map(scheduleDTOMapper::scheduleToScheduleDTO)
        .collect(toList());
  }

  @GetMapping("/pet/{petId}")
  public List<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {
    try {
      return scheduleService
          .getPetSchedule(petService.getPetBy(petId))
          .stream()
          .map(scheduleDTOMapper::scheduleToScheduleDTO)
          .collect(toList());
    } catch (Exception e) {
      throw new ResponseStatusException(NOT_FOUND, "Pet (id:" + petId + ") not found.", e);
    }
  }

  @GetMapping("/employee/{employeeId}")
  public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
    try {
      return scheduleService
          .getEmployeeSchedule(employeeService.getEmployeeBy(employeeId))
          .stream()
          .map(scheduleDTOMapper::scheduleToScheduleDTO)
          .collect(toList());
    } catch (Exception e) {
      throw new ResponseStatusException(NOT_FOUND, "Employee (id:" + employeeId + ") not found.", e);
    }
  }

  @GetMapping("/customer/{customerId}")
  public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
    try {
      return customerService
          .getCustomer(customerId)
          .getPets()
          .stream()
          .map(scheduleService::getPetSchedule)
          .flatMap(Collection::stream)
          .map(scheduleDTOMapper::scheduleToScheduleDTO)
          .collect(toList());
    } catch (Exception e) {
      throw new ResponseStatusException(NOT_FOUND, "Customer (id:" + customerId + ") not found.", e);
    }
  }
}
