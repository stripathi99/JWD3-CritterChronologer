package com.udacity.jdnd.course3.critter.mapper;

import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;
import static org.springframework.beans.BeanUtils.copyProperties;

import com.udacity.jdnd.course3.critter.dto.ScheduleDTO;
import com.udacity.jdnd.course3.critter.model.Employee;
import com.udacity.jdnd.course3.critter.model.Pet;
import com.udacity.jdnd.course3.critter.model.Schedule;
import org.springframework.stereotype.Component;

@Component
public class ScheduleDTOMapper {

  public Schedule scheduleDTOToSchedule(ScheduleDTO scheduleDTO) {
    Schedule schedule = new Schedule();
    copyProperties(scheduleDTO, schedule);

    // employeeId -> employee
    // petID -> pet

    return schedule;
  }

  public ScheduleDTO scheduleToScheduleDTO(Schedule schedule) {
    ScheduleDTO scheduleDTO = new ScheduleDTO();
    copyProperties(schedule, scheduleDTO);

    if (nonNull(schedule.getEmployees())) {
      scheduleDTO.setEmployeeIds(
          schedule.getEmployees()
              .stream()
              .mapToLong(Employee::getId)
              .boxed()
              .collect(toList())
      );
    }

    if (nonNull(schedule.getPets())) {
      scheduleDTO.setPetIds(
          schedule.getPets()
              .stream()
              .mapToLong(Pet::getId)
              .boxed()
              .collect(toList())
      );
    }

    return scheduleDTO;
  }
}
