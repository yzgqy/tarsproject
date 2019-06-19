package com.mytars.petclinic.visitsserver;

import com.qq.tars.spring.annotation.EnableTarsServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableTarsServer
public class VisitsServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(VisitsServerApplication.class, args);
    }

}
