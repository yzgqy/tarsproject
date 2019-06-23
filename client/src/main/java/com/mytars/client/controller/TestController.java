package com.mytars.client.controller;

import com.mytars.client.tars.vets.Vet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: yaya
 * @Date: 2019/6/22 17:10
 * @Description:
 */
@RequestMapping("/test")
@RestController
public class TestController {
//    @Autowired
//    private ApplicationContext context ;

    @Autowired
    private Vet vet ;
    @GetMapping
    public Vet showResourcesVetList() {
        return vet;
    }
}
