package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.enums.EmployeeSkill;
import com.udacity.jdnd.course3.critter.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;
@Repository

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findDistinctBySkillsInAndDaysAvailableIn(Set<EmployeeSkill> skills , Set<DayOfWeek> day);

}
