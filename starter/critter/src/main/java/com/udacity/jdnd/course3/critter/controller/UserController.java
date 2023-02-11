package com.udacity.jdnd.course3.critter.controller;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.udacity.jdnd.course3.critter.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.dto.EmployeeDTO;
import com.udacity.jdnd.course3.critter.dto.EmployeeRequestDTO;
import com.udacity.jdnd.course3.critter.mapper.CustomerDTOMapper;
import com.udacity.jdnd.course3.critter.service.CustomerService;
import com.udacity.jdnd.course3.critter.service.PetService;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;
import org.springframework.web.server.ResponseStatusException;

/**
 * Handles web requests related to Users.
 * <p>
 * Includes requests for both customers and employees. Splitting this into separate user and
 * customer controllers would be fine too, though that is not part of the required scope for this
 * class.
 */
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private CustomerDTOMapper customerDTOMapper;

  @Autowired
  private CustomerService customerService;

  @Autowired
  private PetService petService;

  @PostMapping("/customer")
  public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) {
    try {
      return customerDTOMapper.customerToCustomerDTO(
          customerService.saveCustomer(customerDTOMapper.customerDTOToCustomer(customerDTO)));
    } catch (Exception e) {
      throw new ResponseStatusException(BAD_REQUEST, "Customer could not be saved", e);
    }
  }

  @GetMapping("/customer")
  public List<CustomerDTO> getAllCustomers() {
    return customerService.list()
        .stream()
        .map(customerDTOMapper::customerToCustomerDTO)
        .collect(Collectors.toList());
    //throw new UnsupportedOperationException();
  }

  @GetMapping("/customer/pet/{petId}")
  public CustomerDTO getOwnerByPet(@PathVariable long petId) {
    try {
      return customerDTOMapper.customerToCustomerDTO(
          customerService.getPetOwner(petService.getPetBy(petId)));
    } catch (Exception e) {
      throw new ResponseStatusException(NOT_FOUND, "No Pet found", e);
    }
  }

  @PostMapping("/employee")
  public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
    throw new UnsupportedOperationException();
  }

  @PostMapping("/employee/{employeeId}")
  public EmployeeDTO getEmployee(@PathVariable long employeeId) {
    throw new UnsupportedOperationException();
  }

  @PutMapping("/employee/{employeeId}")
  public void setAvailability(@RequestBody Set<DayOfWeek> daysAvailable,
      @PathVariable long employeeId) {
    throw new UnsupportedOperationException();
  }

  @GetMapping("/employee/availability")
  public List<EmployeeDTO> findEmployeesForService(@RequestBody EmployeeRequestDTO employeeDTO) {
    throw new UnsupportedOperationException();
  }

}
