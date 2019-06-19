package com.mytars.petclinic.client;

import com.mytars.petclinic.client.vets.Vet;
import com.mytars.petclinic.client.vets.VetResourcePrx;
import com.qq.tars.spring.annotation.TarsClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: yaya
 * @Date: 2019/6/18 17:00
 * @Description:
 */
@Component
public class Client {

    @TarsClient(name = "TestApp.HelloJavaServer.HelloObj")
    private VetResourcePrx proxy;

    public void test() {
        List<Vet> ret = proxy.showResourcesVetList();
        System.out.println(ret);
    }
}
