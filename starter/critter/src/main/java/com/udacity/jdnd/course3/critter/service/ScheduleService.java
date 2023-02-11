package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.model.Employee;
import com.udacity.jdnd.course3.critter.model.Pet;
import com.udacity.jdnd.course3.critter.model.Schedule;
import com.udacity.jdnd.course3.critter.repository.ScheduleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

  @Autowired
  private ScheduleRepository scheduleRepository;

  public Schedule saveSchedule(Schedule schedule) {
    return scheduleRepository.save(schedule);
  }

  public List<Schedule> list() {
    return scheduleRepository.findAll();
  }

  public List<Schedule> getEmployeeSchedule(Employee employee) {
    return scheduleRepository.findByEmployees(employee);
  }

  public List<Schedule> getPetSchedule(Pet pet) {
    return scheduleRepository.findByPets(pet);
  }
}
