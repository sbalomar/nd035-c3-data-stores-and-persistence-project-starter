package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.dto.EmployeeDTO;
import com.udacity.jdnd.course3.critter.dto.EmployeeRequestDTO;
import com.udacity.jdnd.course3.critter.entity.Employee;
import com.udacity.jdnd.course3.critter.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee getEmployee(long employeeId){
        return employeeRepository.findById(employeeId).orElseThrow(()-> new RuntimeException("Not found"));
    }

    public void setAvailability(Set<DayOfWeek> daysAvailable, long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if(employee!=null) {
            employee.setDaysAvailable(daysAvailable);
            employeeRepository.save(employee);
        }
    }

    public List<Employee> findEmployeesForService(EmployeeRequestDTO employeeDTO) {
        List<Employee> employees = employeeRepository.findDistinctBySkillsInAndDaysAvailableIn(employeeDTO.getSkills(), Collections.singleton(employeeDTO.getDate().getDayOfWeek()));
        return employees.stream().filter(employee -> employee.getSkills().containsAll(employeeDTO.getSkills())).collect(Collectors.toList());    }

    public List<Employee> mapIdsToEmployees(List<Long> employeeIds){
        if(employeeIds == null)
            return null;
        return employeeRepository.findAllById(employeeIds);
    }
    public List<Long> mapEmployeesToIds(List<Employee> employees){
        if(employees == null)
            return null;
        return employees.stream().map(Employee::getId).collect(Collectors.toList());
    }
}
