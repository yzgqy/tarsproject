package com.mytars.client.customers;

import com.mytars.client.visits.Visit;
import com.mytars.client.visits.VisitResourcePrx;
import com.mytars.client.visits.Visits;
import com.qq.tars.client.Communicator;
import com.qq.tars.client.CommunicatorConfig;
import com.qq.tars.client.CommunicatorFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: yaya
 * @Date: 2019/6/18 14:58
 * @Description:
 */
public class CustomersTest {
    public static void main(String[] args) {
        CommunicatorConfig cfg = new CommunicatorConfig();
        Communicator communicator = CommunicatorFactory.getInstance().getCommunicator(cfg);
        OwnerResourcePrx ownerProxy = communicator.stringToProxy(OwnerResourcePrx.class, "PetclinicApp.CustomersServer.OwnersObj@tcp -h 127.0.0.1 -p 18600 -t 6000");
//        PetResourcePrx petProxy = communicator.stringToProxy(PetResourcePrx.class, "PetclinicApp.CustomersServer.PetsObj@tcp -h 127.0.0.1 -p 18602 -t 6000");
//        Owner ownerT = new Owner();
//        ownerT.setAddress("Address");
//        ownerT.setCity("City");
//        ownerT.setFirstName("FirstName");
//        ownerT.setLastName("LastName");
//        ownerT.setTelephone("1234567890");
//        List<Pet> pets = new ArrayList<>();
//        Pet pet = new Pet();
//        pet.setBirthDate("2019-03-04");
//        pet.setName("baby");
////        pet.setPetType();
//        pets.add(pet);
//        ownerT.setPets(pets);
//        Owner owner1 = ownerProxy.createOwner(ownerT);
//        System.out.println(owner1);
//
//        Owner owner2 = ownerProxy.findOwner(1);
//        System.out.println(owner2);
//
//        List<Owner> owners = ownerProxy.findAll();
//        System.out.println(owners);
//
//        ownerProxy.updateOwner(1,ownerT);
//
//        Owner owner3 = ownerProxy.findOwner(1);
//        System.out.println(owner3);

//        List<PetType> types = petProxy.getPetTypes();
//        System.out.println(types);
//
//        PetRequest petRequest = new PetRequest();
//        petRequest.setBirthDate("2018-03-21");
//        petRequest.setName("xiaoming");
//        petRequest.setTypeId(2);
//        Pet pet1 =petProxy.processCreationForm(petRequest,1);
//        System.out.println(pet1);
//
//        petRequest.setId(1);
//        petProxy.processUpdateForm(petRequest);
//
//        PetDetails d = petProxy.findPet(1);
//        System.out.println(d);


    }
}
