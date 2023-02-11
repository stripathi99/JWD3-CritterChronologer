package com.udacity.jdnd.course3.critter.mapper;

import static org.springframework.beans.BeanUtils.copyProperties;

import com.udacity.jdnd.course3.critter.dto.EmployeeDTO;
import com.udacity.jdnd.course3.critter.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDTOMapper {

  public Employee employeeDTOToEmployee(EmployeeDTO employeeDTO) {
    Employee employee = new Employee();
    copyProperties(employeeDTO, employee);
    return employee;
  }

  public EmployeeDTO employeeToEmployeeDTO(Employee employee) {
    EmployeeDTO employeeDTO = new EmployeeDTO();
    copyProperties(employee, employeeDTO);
    return employeeDTO;
  }
}