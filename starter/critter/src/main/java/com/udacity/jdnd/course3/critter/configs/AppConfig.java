package com.udacity.jdnd.course3.critter.configs;

import com.udacity.jdnd.course3.critter.dto.PetDTO;
import com.udacity.jdnd.course3.critter.entity.Pet;
import com.udacity.jdnd.course3.critter.mapper.PetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public PetMapper petMapper() {
        return new PetMapper() {
            @Override
            public PetDTO mapEntityToDTO(Pet pet) {
                return null;
            }

            @Override
            public Pet mapDTOToEntity(PetDTO petDTO) {
                return null;
            }
        };
    }
}
