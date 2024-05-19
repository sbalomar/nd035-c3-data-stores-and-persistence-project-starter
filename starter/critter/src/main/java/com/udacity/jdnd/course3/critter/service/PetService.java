package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.dto.PetDTO;
import com.udacity.jdnd.course3.critter.entity.Customer;
import com.udacity.jdnd.course3.critter.entity.Pet;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PetService {
    private final PetRepository petRepository;
    private final CustomerRepository customerRepository;

    public PetService(PetRepository petRepository, CustomerRepository customerRepository) {
        this.petRepository = petRepository;
        this.customerRepository = customerRepository;
    }


    public Pet savePet(Pet pet) {
        Pet addedPet = petRepository.save(pet);
        Customer owner = addedPet.getOwner();
        List<Pet> petsOwner = owner.getPets();

        if(petsOwner == null)
            petsOwner = new ArrayList<>();

        petsOwner.add(addedPet);
        owner.setPets(petsOwner);
        customerRepository.save(owner);

        return addedPet;
    }

    public Pet getPet(long petId) {
       return petRepository.findById(petId).orElse(null);
    }
    public List<Pet> getPets(){
        return petRepository.findAll();
    }

    public List<Pet> getPetsByOwner(long ownerId){
        return petRepository.findByOwnerId(ownerId);
    }

    public List<Pet> mapIdsToPets(List<Long> petIds){
        if(petIds == null)
            return null;
        return petRepository.findAllById(petIds);
    }
    public List<Long> mapPetsToIds(List<Pet> pets){
        if(pets == null)
            return null;
        return pets.stream().map(Pet::getId).collect(Collectors.toList());
    }
}