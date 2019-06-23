package com.mytars.client.controller;

import com.mytars.client.tars.customers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: yaya
 * @Date: 2019/6/22 17:24
 * @Description:
 */
@RestController
public class PetController {
    @Autowired
    private PetResourcePrx petResourcePrx;

    @GetMapping("/petTypes")
    public List<PetType> getPetTypes() {
        return petResourcePrx.getPetTypes();
    }

    @PostMapping("/owners/{ownerId}/pets")
    @ResponseStatus(HttpStatus.CREATED)
    public Pet processCreationForm(
            @RequestBody PetRequest petRequest,
            @PathVariable("ownerId") int ownerId) {
        return petResourcePrx.processCreationForm(petRequest,ownerId);
    }

    @PutMapping("/owners/*/pets/{petId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void processUpdateForm(@RequestBody PetRequest petRequest) {
        petResourcePrx.processUpdateForm(petRequest);
    }

    @GetMapping("owners/*/pets/{petId}")
    public PetDetails findPet(@PathVariable("petId") int petId) {
        return petResourcePrx.findPet(petId);
    }
}
