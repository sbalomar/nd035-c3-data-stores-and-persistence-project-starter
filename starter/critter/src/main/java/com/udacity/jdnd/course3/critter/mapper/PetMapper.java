package com.udacity.jdnd.course3.critter.mapper;

import com.udacity.jdnd.course3.critter.dto.PetDTO;
import com.udacity.jdnd.course3.critter.entity.Pet;
import com.udacity.jdnd.course3.critter.service.CustomerService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = CustomerService.class)
public interface PetMapper {
    @Mapping(target = "ownerId", source = "owner.id")
    PetDTO mapEntityToDTO(Pet pet);
    @Mapping(target = "owner", source = "ownerId")
    Pet mapDTOToEntity(PetDTO petDTO);

}
