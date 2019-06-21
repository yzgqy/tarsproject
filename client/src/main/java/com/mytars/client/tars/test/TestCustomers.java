package com.mytars.client.tars.test;

import com.mytars.client.tars.customers.*;
import com.qq.tars.client.Communicator;
import com.qq.tars.client.CommunicatorConfig;
import com.qq.tars.client.CommunicatorFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: yaya
 * @Date: 2019/6/21 11:05
 * @Description:
 */
public class TestCustomers {
    public static void main(String[] args) {
        CommunicatorConfig cfg = new CommunicatorConfig();
        Communicator communicator = CommunicatorFactory.getInstance().getCommunicator(cfg);
//        OwnerResourcePrx ownerProxy = communicator.stringToProxy(OwnerResourcePrx.class, "PetclinicApp.CustomersServer.OwnersObj@tcp -h 127.0.0.1 -p 18604 -t 60000");
        OwnerResourcePrx ownerProxy = communicator.stringToProxy(OwnerResourcePrx.class, "PetclinicApp.CustomersServer.OwnersObj@tcp -h 172.16.196.131 -p 18602");

        Owner ownerT = new Owner();
        ownerT.setAddress("Address");
        ownerT.setCity("City");
        ownerT.setFirstName("FirstName");
        ownerT.setLastName("LastName");
        ownerT.setTelephone("1234567890");
        List<Pet> pets = new ArrayList<>();
        Pet pet = new Pet();
        pet.setBirthDate("2019-03-04");
        pet.setName("baby");
//        pet.setPetType();
        pets.add(pet);
        ownerT.setPets(pets);
        Owner owner1 = ownerProxy.createOwner(ownerT);
        System.out.println("1 "+owner1);

        Owner owner2 = ownerProxy.findOwner(1);
        System.out.println("2 "+owner2);

        List<Owner> owners = ownerProxy.findAll();
        System.out.println("3 "+owners);

        ownerProxy.updateOwner(1,ownerT);

        Owner owner3 = ownerProxy.findOwner(1);
        System.out.println("4 "+owner3);

        PetResourcePrx petProxy = communicator.stringToProxy(PetResourcePrx.class, "PetclinicApp.CustomersServer.PetsObj@tcp -h 172.16.196.131 -p 18602");
        List<PetType> types = petProxy.getPetTypes();
        System.out.println("5 "+types);

        PetRequest petRequest = new PetRequest();
        petRequest.setBirthDate("2018-03-21");
        petRequest.setName("xiaoming");
        petRequest.setTypeId(2);
        Pet pet1 =petProxy.processCreationForm(petRequest,1);
        System.out.println("6 "+pet1);

        petRequest.setId(1);
        petRequest.setName("xiaomingaaa");
        petProxy.processUpdateForm(petRequest);

        PetDetails d = petProxy.findPet(11);
        System.out.println("7 "+d);

        PetDetails d2 = petProxy.findPet(10);
        System.out.println("8 "+d2);


    }
}
