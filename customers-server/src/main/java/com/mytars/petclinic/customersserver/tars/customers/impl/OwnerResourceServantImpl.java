package com.mytars.petclinic.customersserver.tars.customers.impl;

import com.mytars.petclinic.customersserver.model.OwnerRepository;
import com.mytars.petclinic.customersserver.tars.customers.Owner;
import com.mytars.petclinic.customersserver.tars.customers.OwnerResourceServant;
import com.mytars.petclinic.customersserver.web.ResourceNotFoundException;
import com.qq.tars.spring.annotation.TarsServant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@TarsServant("OwnersObj")
public class OwnerResourceServantImpl implements OwnerResourceServant {
    private final OwnerRepository ownerRepository;

    @Override
    public Owner createOwner(Owner owner) {
        com.mytars.petclinic.customersserver.model.Owner ownerModel = new com.mytars.petclinic.customersserver.model.Owner(owner);
//        ownerModel.setAddress(owner.getAddress());
//        ownerModel.setCity(owner.getCity());
//        ownerModel.setFirstName(owner.getFirstName());
//        ownerModel.setLastName(owner.getLastName());
//        ownerModel.setTelephone(owner.getTelephone());
//        List<Pet> tarsPets = owner.getPets();
//        for(Pet tarsPet:tarsPets){
//            com.mytars.petclinic.customersserver.model.Pet pet = new com.mytars.petclinic.customersserver.model.Pet();
//            pet.setBirthDate(tarsPet.getBirthDate());
//            pet.setName(tarsPet.getName());
//            pet.setId(tarsPet.getId());
//            PetType tarsType = tarsPet.getPetType();
//            com.mytars.petclinic.customersserver.model.PetType typeModel = new com.mytars.petclinic.customersserver.model.PetType();
//            typeModel.setId(tarsType.getId());
//            typeModel.setName(tarsType.getName());
//            pet.setType(typeModel);
////            Owner tarsOwner = tarsPet.getOwner();
////            com.mytars.petclinic.customersserver.model.Owner ownerModel2 = new com.mytars.petclinic.customersserver.model.Owner();
////            ownerModel2.setTelephone(tarsOwner.getTelephone());
////            ownerModel2.setLastName(tarsOwner.getLastName());
////            ownerModel2.setFirstName(tarsOwner.getFirstName());
////            ownerModel2.setCity(tarsOwner.getCity());
////            ownerModel2.setAddress(tarsOwner.getAddress());
////            pet.setOwner();
//            ownerModel.addPet(pet);
//        }
        com.mytars.petclinic.customersserver.model.Owner ownerMode3 = ownerRepository.save(ownerModel);
        owner.setId(ownerMode3.getId());
        return owner;
    }

    @Override
    public Owner findOwner(int ownerId) {
        Optional<com.mytars.petclinic.customersserver.model.Owner> ownerModelP= ownerRepository.findById(ownerId);
        return ownerModelP.orElse(null).toTarsOwner();
    }

    @Override
    public List<Owner> findAll() {
        List<com.mytars.petclinic.customersserver.model.Owner> ownerModels = ownerRepository.findAll();
        List<Owner> tarsOwners = new ArrayList<>();
        for (com.mytars.petclinic.customersserver.model.Owner ownerModel : ownerModels){
            tarsOwners.add(ownerModel.toTarsOwner());
        }
        return tarsOwners;
    }

    @Override
    public void updateOwner(int ownerId, Owner ownerRequest) {
        final Optional<com.mytars.petclinic.customersserver.model.Owner> owner = ownerRepository.findById(ownerId);

        final com.mytars.petclinic.customersserver.model.Owner ownerModel = owner.orElseThrow(() -> new ResourceNotFoundException("Owner "+ownerId+" not found"));
        // This is done by hand for simplicity purpose. In a real life use-case we should consider using MapStruct.
        ownerModel.setFirstName(ownerRequest.getFirstName());
        ownerModel.setLastName(ownerRequest.getLastName());
        ownerModel.setCity(ownerRequest.getCity());
        ownerModel.setAddress(ownerRequest.getAddress());
        ownerModel.setTelephone(ownerRequest.getTelephone());
        log.info("Saving owner {}", ownerModel);
        ownerRepository.save(ownerModel);

    }
}
