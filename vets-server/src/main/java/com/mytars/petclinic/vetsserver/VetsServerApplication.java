package com.mytars.petclinic.vetsserver;

import com.mytars.petclinic.vetsserver.system.VetsProperties;
import com.qq.tars.spring.annotation.EnableTarsServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(VetsProperties.class)
@EnableTarsServer
public class VetsServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(VetsServerApplication.class, args);
    }

}
