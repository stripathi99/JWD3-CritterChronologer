package com.udacity.jdnd.course3.critter.mapper;

import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;
import static org.springframework.beans.BeanUtils.copyProperties;

import com.udacity.jdnd.course3.critter.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.model.Customer;
import com.udacity.jdnd.course3.critter.model.Pet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class CustomerDTOMapper {

  public Customer customerDTOToCustomer(CustomerDTO customerDTO) {
    Customer customer = new Customer();
    copyProperties(customerDTO, customer);

    List<Long> petIds = customerDTO.getPetIds();

    // for each petId -> call petService to retrieve Pet
    // collect to pets list
    List<Pet> pets = null;
    customer.setPets(pets);

    return customer;
  }

  public CustomerDTO customerToCustomerDTO(Customer customer) {
    CustomerDTO customerDTO = new CustomerDTO();
    copyProperties(customer, customerDTO);

    if (nonNull(customer.getPets())) {
      customerDTO.setPetIds(
          customer.getPets()
              .stream()
              .mapToLong(Pet::getId)
              .boxed()
              .collect(toList())
      );
    }

    return customerDTO;
  }
}