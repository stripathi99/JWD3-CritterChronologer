package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.model.Employee;
import com.udacity.jdnd.course3.critter.model.EmployeeSkill;
import com.udacity.jdnd.course3.critter.repository.EmployeeRepository;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  public Employee saveEmployee(Employee employee) {
    return employeeRepository.save(employee);
  }

  public List<Employee> list() {
    return employeeRepository.findAll();
  }

  public Employee getEmployeeBy(Long id) {
    return employeeRepository.getOne(id);
  }

  public List<Employee> getAvailableEmployees(LocalDate date, Set<EmployeeSkill> skills) {
    return employeeRepository
        .findByDaysAvailable(date.getDayOfWeek())
        .stream()
        .filter(employee -> employee.getSkills().containsAll(skills))
        .collect(Collectors.toList());
  }

  public void setAvailabilityOfEmployee(Set<DayOfWeek> days, Long employeeId) {
    Employee employee = this.getEmployeeBy(employeeId);
    employee.setDaysAvailable(days);
    employeeRepository.save(employee);
  }

}