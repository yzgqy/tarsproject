package com.mytars.client.controller;

import com.mytars.client.tars.visits.Visit;
import com.mytars.client.tars.visits.VisitResourcePrx;
import com.mytars.client.tars.visits.Visits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Auther: yaya
 * @Date: 2019/6/22 17:23
 * @Description:
 */
@RestController
public class VisitController {
    @Autowired
    private VisitResourcePrx visitResourcePrx;

    @PostMapping("owners/*/pets/{petId}/visits")
    @ResponseStatus(HttpStatus.CREATED)
    public Visit create(
            @Valid @RequestBody Visit visit,
            @PathVariable("petId") int petId) {
        return visitResourcePrx.create(visit,petId);
    }

    @GetMapping("owners/*/pets/{petId}/visits")
    public List<Visit> visits(@PathVariable("petId") int petId) {
        return visitResourcePrx.visits(petId);
    }

    @GetMapping("pets/visits")
    public Visits visitsMultiGet(@RequestParam("petId") List<Integer> petIds) {
        return visitResourcePrx.visitsMultiGet(petIds);
    }
}
