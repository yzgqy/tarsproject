package com.mytars.client.tars.test;

import com.mytars.client.tars.visits.Visit;
import com.mytars.client.tars.visits.VisitResourcePrx;
import com.mytars.client.tars.visits.Visits;
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
public class TestVisits {
    public static void main(String[] args) {
        CommunicatorConfig cfg = new CommunicatorConfig();
        Communicator communicator = CommunicatorFactory.getInstance().getCommunicator(cfg);
        VisitResourcePrx proxy = communicator.stringToProxy(VisitResourcePrx.class, "PetclinicApp.VisitsServer.VisitsObj@tcp -h 172.16.196.131 -p 18601");
//        VisitResourcePrx proxy = communicator.stringToProxy(VisitResourcePrx.class, "PetclinicApp.VisitsServer.VisitsObj@tcp -h 127.0.0.1 -p 18602");
        //        Visit create(Visit visit, int petId);
        Visit visit = new Visit();
        visit.setDate("2018-03-04");
        visit.setDescription("test");
        Visit visitR = proxy.create(visit,2);
        System.out.println("返回1： "+visitR);

//        java.util.List<Visit> visits(int petId);

        List<Visit> visitList = proxy.visits(2);
        System.out.println("返回2： "+visitList);

//        Visits visitsMultiGet(java.util.List<java.lang.Integer> petIds);
        List<Integer> petIds = new ArrayList<>();
        petIds.add(1);
        petIds.add(2);
        Visits visits = proxy.visitsMultiGet(petIds);
        System.out.println("返回3： "+visits);
    }
}
