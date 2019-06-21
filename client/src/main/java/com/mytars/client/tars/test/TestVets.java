package com.mytars.client.tars.test;

import com.mytars.client.tars.vets.Vet;
import com.mytars.client.tars.vets.VetResourcePrx;
import com.qq.tars.client.Communicator;
import com.qq.tars.client.CommunicatorConfig;
import com.qq.tars.client.CommunicatorFactory;

import java.util.List;

/**
 * @Auther: yaya
 * @Date: 2019/6/21 11:05
 * @Description:
 */
public class TestVets {
    public static void main(String[] args) {
        CommunicatorConfig cfg = new CommunicatorConfig();
        Communicator communicator = CommunicatorFactory.getInstance().getCommunicator(cfg);
        VetResourcePrx proxy = communicator.stringToProxy(VetResourcePrx.class, "PetclinicApp.VetsServer.VetsObj@tcp -h 172.16.196.131 -p 18600");
//        VetResourcePrx proxy = communicator.stringToProxy(VetResourcePrx.class, "PetclinicApp.VetsServer.VetsObj@tcp -h 127.0.0.1 -t 60000 -p 18600");

        //同步调用
        List<Vet> vets = proxy.showResourcesVetList();
        System.out.println("返回： "+vets);
    }
}
