package com.mytars.petclinic.customersserver.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PetRepository extends JpaRepository<Pet, Integer> {

    /**
     * Retrieve all {@link PetType}s from the data store.
     * @return a Collection of {@link PetType}s.
     */
    @Query("SELECT ptype FROM PetType ptype ORDER BY ptype.name")
    List<PetType> findPetTypes();

    @Query("FROM PetType ptype WHERE ptype.id = :typeId")
    Optional<PetType> findPetTypeById(@Param("typeId") int typeId);


}