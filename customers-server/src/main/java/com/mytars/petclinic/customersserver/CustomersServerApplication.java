package com.mytars.petclinic.customersserver;

import com.qq.tars.spring.annotation.EnableTarsServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTarsServer
public class CustomersServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomersServerApplication.class, args);
    }

}
