package com.mytars.petclinic.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext =  SpringApplication.run(ClientApplication.class, args);
        Client test = applicationContext.getBean(Client.class);
        test.test();
    }

}
