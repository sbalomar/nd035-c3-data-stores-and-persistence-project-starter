package com.udacity.jdnd.course3.critter.mapper;


import com.udacity.jdnd.course3.critter.dto.EmployeeDTO;
import com.udacity.jdnd.course3.critter.entity.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    EmployeeDTO mapEntityToDTO(Employee employee);
    List<EmployeeDTO> mapEntityToDTO(List<Employee> employee);
    Employee mapDTOToEntity(EmployeeDTO employeeDTO);
    List<Employee> mapDTOToEntity(List<EmployeeDTO> employeeDTO);

}
