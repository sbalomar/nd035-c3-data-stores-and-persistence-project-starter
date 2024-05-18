package com.udacity.jdnd.course3.critter.mapper;

import com.udacity.jdnd.course3.critter.dto.ScheduleDTO;
import com.udacity.jdnd.course3.critter.entity.Schedule;
import com.udacity.jdnd.course3.critter.service.EmployeeService;
import com.udacity.jdnd.course3.critter.service.PetService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = {EmployeeService.class , PetService.class})
public interface ScheduleMapper {
    @Mapping(target = "employeeIds" , source = "employees")
    @Mapping(target = "petIds" , source = "pets")
    ScheduleDTO mapEntityToDTO(Schedule schedule);
    @Mapping(target = "employees" , source = "employeeIds")
    @Mapping(target = "pets" , source = "petIds")
    Schedule mapDTOToEntity(ScheduleDTO scheduleDTO);
    @Mapping(target = "employeeIds" , source = "employees")
    @Mapping(target = "petIds" , source = "pets")
    List<ScheduleDTO> mapEntityToDTO(List<Schedule> schedule);
}
