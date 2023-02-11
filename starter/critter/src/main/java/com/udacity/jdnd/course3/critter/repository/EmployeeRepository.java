package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.model.Employee;
import java.time.DayOfWeek;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  List<Employee> findByDaysAvailable(DayOfWeek dayOfWeek);
}
