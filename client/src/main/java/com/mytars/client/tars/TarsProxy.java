package com.mytars.client.tars;

import com.mytars.client.tars.customers.OwnerResourcePrx;
import com.mytars.client.tars.customers.PetResourcePrx;
import com.mytars.client.tars.vets.VetResourcePrx;
import com.mytars.client.tars.visits.VisitResourcePrx;
import com.qq.tars.client.Communicator;
import com.qq.tars.client.CommunicatorConfig;
import com.qq.tars.client.CommunicatorFactory;
import org.springframework.context.annotation.Bean;

/**
 * @Auther: yaya
 * @Date: 2019/6/21 11:08
 * @Description:
 */
public class TarsProxy {

    @Bean
    public VetResourcePrx getVetPrx(){
        CommunicatorConfig cfg = new CommunicatorConfig();
        Communicator communicator = CommunicatorFactory.getInstance().getCommunicator(cfg);
        VetResourcePrx proxy = communicator.stringToProxy(VetResourcePrx.class, "PetclinicApp.VetsServer.VetsObj@tcp -h 172.16.196.131 -p 18600");
        return proxy;
    }

    @Bean
    public VisitResourcePrx getVisitPrx(){
        CommunicatorConfig cfg = new CommunicatorConfig();
        Communicator communicator = CommunicatorFactory.getInstance().getCommunicator(cfg);
        VisitResourcePrx proxy = communicator.stringToProxy(VisitResourcePrx.class, "PetclinicApp.VisitsServer.VisitsObj@tcp -h 172.16.196.131 -p 18601");
        return proxy;
    }

    @Bean
    public OwnerResourcePrx getOwnerPrx(){
        CommunicatorConfig cfg = new CommunicatorConfig();
        Communicator communicator = CommunicatorFactory.getInstance().getCommunicator(cfg);
        OwnerResourcePrx proxy = communicator.stringToProxy(OwnerResourcePrx.class, "PetclinicApp.CustomersServer.OwnersObj@tcp -h 172.16.196.131 -p 18602");
        return proxy;
    }

    @Bean
    public PetResourcePrx getPetPrx(){
        CommunicatorConfig cfg = new CommunicatorConfig();
        Communicator communicator = CommunicatorFactory.getInstance().getCommunicator(cfg);
        PetResourcePrx proxy = communicator.stringToProxy(PetResourcePrx.class, "PetclinicApp.CustomersServer.PetsObj@tcp -h 172.16.196.131 -p 18602");
        return proxy;
    }
}
