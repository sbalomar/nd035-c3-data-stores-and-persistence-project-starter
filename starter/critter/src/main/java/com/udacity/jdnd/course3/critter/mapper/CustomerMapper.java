package com.udacity.jdnd.course3.critter.mapper;

import com.udacity.jdnd.course3.critter.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.entity.Customer;
import com.udacity.jdnd.course3.critter.service.PetService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = PetService.class)
public interface CustomerMapper {
    @Mapping(target="petIds" , source = "pets")
    CustomerDTO mapEntityToDTO(Customer customer);
    @Mapping(target="pets" , source = "petIds")
    Customer mapDTOToEntity(CustomerDTO customer);

}
