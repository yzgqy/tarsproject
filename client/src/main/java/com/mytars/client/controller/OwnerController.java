package com.mytars.client.controller;

import com.mytars.client.tars.customers.Owner;
import com.mytars.client.tars.customers.OwnerResourcePrx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * @Auther: yaya
 * @Date: 2019/6/22 17:23
 * @Description:
 */
@RequestMapping("/owners")
@RestController
public class OwnerController {
    @Autowired
    private OwnerResourcePrx ownerResourcePrx;

    /**
     * Create Owner
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Owner createOwner(@Valid @RequestBody Owner owner) {
        return ownerResourcePrx.createOwner(owner);
    }

    /**
     * Read single Owner
     */
    @GetMapping(value = "/{ownerId}")
    public Owner findOwner(@PathVariable("ownerId") int ownerId) {
        return ownerResourcePrx.findOwner(ownerId);
    }

    /**
     * Read List of Owners
     */
    @GetMapping
    public List<Owner> findAll() {
        return ownerResourcePrx.findAll();
    }

    /**
     * Update Owner
     */
    @PutMapping(value = "/{ownerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateOwner(@PathVariable("ownerId") int ownerId, @Valid @RequestBody Owner ownerRequest) {
        ownerResourcePrx.updateOwner(ownerId,ownerRequest);
    }

}
