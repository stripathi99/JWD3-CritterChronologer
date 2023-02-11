package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.model.Customer;
import com.udacity.jdnd.course3.critter.model.Pet;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  public Customer saveCustomer(Customer customer) {
    return customerRepository.save(customer);
  }

  public List<Customer> list() {
    return customerRepository.findAll();
  }

  public Customer getCustomer(Long id) {
    return customerRepository.getOne(id);
  }

  public Customer getPetOwner(Pet pet) {
    return customerRepository.findByPets(pet);
  }
}
