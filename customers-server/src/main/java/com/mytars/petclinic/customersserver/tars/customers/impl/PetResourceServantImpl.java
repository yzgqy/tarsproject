package com.mytars.petclinic.customersserver.tars.customers.impl;

import com.mytars.petclinic.customersserver.model.OwnerRepository;
import com.mytars.petclinic.customersserver.model.PetRepository;
import com.mytars.petclinic.customersserver.tars.customers.*;
import com.mytars.petclinic.customersserver.web.ResourceNotFoundException;
import com.qq.tars.spring.annotation.TarsServant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Auther: yaya
 * @Date: 2019/6/18 11:08
 * @Description:
 */
@RequiredArgsConstructor
@Slf4j
@TarsServant("PetsObj")
public class PetResourceServantImpl implements PetResourceServant {
    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;

    @Override
    public List<PetType> getPetTypes() {
        List<com.mytars.petclinic.customersserver.model.PetType> typeModels = petRepository.findPetTypes();
        List<PetType> tarsTypes = new ArrayList<>();
        for(com.mytars.petclinic.customersserver.model.PetType typeModel:typeModels){
            tarsTypes.add(typeModel.toTarsType());
        }
        return tarsTypes;
    }

    @Override
    public Pet processCreationForm(PetRequest petRequest, int ownerId) {
        final com.mytars.petclinic.customersserver.model.Pet pet = new com.mytars.petclinic.customersserver.model.Pet();
        final Optional<com.mytars.petclinic.customersserver.model.Owner> optionalOwner = ownerRepository.findById(ownerId);
        com.mytars.petclinic.customersserver.model.Owner owner = optionalOwner.orElseThrow(() -> new ResourceNotFoundException("Owner "+ownerId+" not found"));
        owner.addPet(pet);
        return save(pet, petRequest).toTarsPet();
    }


    @Override
    public void processUpdateForm(PetRequest petRequest) {
        int petId = petRequest.getId();
        com.mytars.petclinic.customersserver.model.Pet pet = findPetById(petId);
        save(pet, petRequest);

    }

    @Override
    public PetDetails findPet(int petId) {
        com.mytars.petclinic.customersserver.web.PetDetails detailModels = new com.mytars.petclinic.customersserver.web.PetDetails(findPetById(petId));

        return detailModels.toTarsPetDetail();
    }



    private com.mytars.petclinic.customersserver.model.Pet save(final com.mytars.petclinic.customersserver.model.Pet pet, final PetRequest petRequest) {

        pet.setName(petRequest.getName());
        pet.setBirthDate(petRequest.getBirthDate());

        petRepository.findPetTypeById(petRequest.getTypeId())
                .ifPresent(pet::setType);

        log.info("Saving pet {}", pet);
        return petRepository.save(pet);
    }

    private com.mytars.petclinic.customersserver.model.Pet findPetById(int petId) {
        Optional<com.mytars.petclinic.customersserver.model.Pet> pet = petRepository.findById(petId);
        if (!pet.isPresent()) {
            throw new ResourceNotFoundException("Pet "+petId+" not found");
        }
        return pet.get();
    }
}
