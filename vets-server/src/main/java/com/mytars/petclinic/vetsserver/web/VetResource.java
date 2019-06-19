package com.mytars.petclinic.vetsserver.web;

import com.mytars.petclinic.vetsserver.model.Vet;
import com.mytars.petclinic.vetsserver.model.VetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: yaya
 * @Date: 2019/6/17 14:52
 * @Description:
 */
@RequestMapping("/vets")
@RestController
@RequiredArgsConstructor
class VetResource {

    private final VetRepository vetRepository;

    @GetMapping
    public List<Vet> showResourcesVetList() {
        return vetRepository.findAll();
    }
}