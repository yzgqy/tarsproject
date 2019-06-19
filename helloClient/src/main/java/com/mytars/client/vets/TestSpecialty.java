package com.mytars.client.vets;

import com.mytars.client.testapp.HelloPrx;
import com.qq.tars.client.Communicator;
import com.qq.tars.client.CommunicatorConfig;
import com.qq.tars.client.CommunicatorFactory;

import java.util.List;

/**
 * @Auther: yaya
 * @Date: 2019/6/17 21:32
 * @Description:
 */
public class TestSpecialty {
    public static void main(String[] args) {
        CommunicatorConfig cfg = new CommunicatorConfig();
        Communicator communicator = CommunicatorFactory.getInstance().getCommunicator(cfg);
        VetResourcePrx proxy = communicator.stringToProxy(VetResourcePrx.class, "PetclinicApp.VetsServer.VetsObj@tcp -h 127.0.0.1 -p 18600 -t 3000");

        //同步调用
        List<Vet> vets = proxy.showResourcesVetList();
        System.out.println("返回： "+vets);
    }
}
