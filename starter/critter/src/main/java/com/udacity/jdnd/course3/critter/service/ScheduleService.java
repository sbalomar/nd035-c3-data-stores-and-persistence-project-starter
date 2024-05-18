package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.dto.ScheduleDTO;
import com.udacity.jdnd.course3.critter.entity.Schedule;
import com.udacity.jdnd.course3.critter.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }
    public Schedule createSchedule(Schedule schedule){
        return scheduleRepository.save(schedule);
    }
    public List<Schedule> getAllSchedules(){
        return scheduleRepository.findAll();
    }
    public List<Schedule> getScheduleForPet(long petId){
        return scheduleRepository.findByPetsId(petId);
    }
    public List<Schedule> getScheduleForEmployee(long employeeId){
        return scheduleRepository.findByEmployeesId(employeeId);
    }
    public List<Schedule> getScheduleForCustomer(long customerId){
        return scheduleRepository.findDistinctByPetsOwnerId(customerId);
    }
    }
