package com.mytars.client.tars;

import com.mytars.client.tars.customers.OwnerResourcePrx;
import com.mytars.client.tars.customers.PetResourcePrx;
import com.mytars.client.tars.vets.Vet;
import com.mytars.client.tars.vets.VetResourcePrx;
import com.mytars.client.tars.visits.VisitResourcePrx;
import com.qq.tars.client.Communicator;
import com.qq.tars.client.CommunicatorConfig;
import com.qq.tars.client.CommunicatorFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: yaya
 * @Date: 2019/6/21 11:08
 * @Description:
 */
@Configuration
public class TarsProxy {

    @Bean("VetPrx")
    public VetResourcePrx getVetPrx(){
        CommunicatorConfig cfg = new CommunicatorConfig();
        Communicator communicator = CommunicatorFactory.getInstance().getCommunicator(cfg);
        VetResourcePrx proxy = communicator.stringToProxy(VetResourcePrx.class, "PetclinicApp.VetsServer.VetsObj@tcp -h 172.16.196.131 -p 18600");
        return proxy;
    }

    @Bean("VisitPrx")
    public VisitResourcePrx getVisitPrx(){
        CommunicatorConfig cfg = new CommunicatorConfig();
        Communicator communicator = CommunicatorFactory.getInstance().getCommunicator(cfg);
        VisitResourcePrx proxy = communicator.stringToProxy(VisitResourcePrx.class, "PetclinicApp.VisitsServer.VisitsObj@tcp -h 172.16.196.131 -p 18601");
        return proxy;
    }

    @Bean("OwnerPrx")
    public OwnerResourcePrx getOwnerPrx(){
        CommunicatorConfig cfg = new CommunicatorConfig();
        Communicator communicator = CommunicatorFactory.getInstance().getCommunicator(cfg);
        OwnerResourcePrx proxy = communicator.stringToProxy(OwnerResourcePrx.class, "PetclinicApp.CustomersServer.OwnersObj@tcp -h 172.16.196.131 -p 18602");
        return proxy;
    }

    @Bean("PetPrx")
    public PetResourcePrx getPetPrx(){
        CommunicatorConfig cfg = new CommunicatorConfig();
        Communicator communicator = CommunicatorFactory.getInstance().getCommunicator(cfg);
        PetResourcePrx proxy = communicator.stringToProxy(PetResourcePrx.class, "PetclinicApp.CustomersServer.PetsObj@tcp -h 172.16.196.131 -p 18602");
        return proxy;
    }

    @Bean("Vet")
    public Vet test(){
        Vet a = new Vet();
        a.setFirstName("fn");
        a.setId(1);
        return a;
    }
}
