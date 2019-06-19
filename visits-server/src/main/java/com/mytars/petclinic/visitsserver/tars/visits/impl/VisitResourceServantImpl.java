package com.mytars.petclinic.visitsserver.tars.visits.impl;

import com.mytars.petclinic.visitsserver.model.VisitRepository;
import com.mytars.petclinic.visitsserver.tars.visits.Visit;
import com.mytars.petclinic.visitsserver.tars.visits.VisitResourceServant;
import com.mytars.petclinic.visitsserver.tars.visits.Visits;
import com.qq.tars.spring.annotation.TarsServant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: yaya
 * @Date: 2019/6/17 22:18
 * @Description:
 */
@RequiredArgsConstructor
@Slf4j
@TarsServant("VisitsObj")
public class VisitResourceServantImpl implements VisitResourceServant {
    private final VisitRepository visitRepository;

    @Override
    public Visit create(Visit visit, int petId) {
        visit.setPetId(petId);
        log.info("Saving visit {}", visit);
        com.mytars.petclinic.visitsserver.model.Visit visitModel = new com.mytars.petclinic.visitsserver.model.Visit();
        visitModel.setPetId(visit.getPetId());
        visitModel.setDate(visit.getDate());
        visitModel.setDescription(visit.getDescription());
        com.mytars.petclinic.visitsserver.model.Visit visitModelNew = visitRepository.save(visitModel);
        visit.setId(visitModelNew.getId());
        return visit;
    }


    @Override
    public List<Visit> visits(int petId) {
        List<com.mytars.petclinic.visitsserver.model.Visit> visitList = visitRepository.findByPetId(petId);
        List<Visit> tarsVisits = new ArrayList<>();
        for(com.mytars.petclinic.visitsserver.model.Visit visit:visitList){
            Visit tarsVisit = new Visit();
            tarsVisit.setId(visit.getId());
            tarsVisit.setPetId(visit.getPetId());
            tarsVisit.setDescription(visit.getDescription());
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = formatter.format(visit.getDate());
            tarsVisit.setDate(dateString);
            tarsVisits.add(tarsVisit);
        }
        return tarsVisits;
    }

    @Override
    public Visits visitsMultiGet(List<Integer> petIds) {
        final List<com.mytars.petclinic.visitsserver.model.Visit> byPetIdIn = visitRepository.findByPetIdIn(petIds);
        List<Visit> tarsVisits = new ArrayList<>();
        for(com.mytars.petclinic.visitsserver.model.Visit visit:byPetIdIn){
            Visit tarsVisit = new Visit();
            tarsVisit.setId(visit.getId());
            tarsVisit.setPetId(visit.getPetId());
            tarsVisit.setDescription(visit.getDescription());
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = formatter.format(visit.getDate());
            tarsVisit.setDate(dateString);
            tarsVisits.add(tarsVisit);
        }
        return new Visits(tarsVisits);
    }
}
