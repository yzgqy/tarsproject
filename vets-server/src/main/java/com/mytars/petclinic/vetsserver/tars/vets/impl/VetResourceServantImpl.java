package com.mytars.petclinic.vetsserver.tars.vets.impl;
import com.mytars.petclinic.vetsserver.model.Specialty;
import com.mytars.petclinic.vetsserver.model.VetRepository;
import com.mytars.petclinic.vetsserver.tars.vets.Vet;
import com.mytars.petclinic.vetsserver.tars.vets.VetResourceServant;
import com.qq.tars.spring.annotation.TarsServant;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Auther: yaya
 * @Date: 2019/6/17 21:10
 * @Description:
 */
@RequiredArgsConstructor
@TarsServant("VetsObj")
public class VetResourceServantImpl implements VetResourceServant {
    private final VetRepository vetRepository;

    @Override
    public List<Vet> showResourcesVetList() {
        System.out.println("调用ok了");
        List<com.mytars.petclinic.vetsserver.model.Vet> vets = vetRepository.findAll();
        List<Vet> myvets = new ArrayList<>();
        for(com.mytars.petclinic.vetsserver.model.Vet vet :vets){
            Vet tarsVet = new Vet();
            tarsVet.setFirstName(vet.getFirstName());
            tarsVet.setId(vet.getId());
            tarsVet.setLastName(vet.getLastName());
            List<Specialty> specialties = vet.getSpecialties();
            List<com.mytars.petclinic.vetsserver.tars.vets.Specialty> tarsSpecialties = new ArrayList<>();
            for(Specialty specialty:specialties){
                com.mytars.petclinic.vetsserver.tars.vets.Specialty tarsSpecialty = new com.mytars.petclinic.vetsserver.tars.vets.Specialty();
                tarsSpecialty.setId(specialty.getId());
                tarsSpecialty.setName(specialty.getName());
                tarsSpecialties.add(tarsSpecialty);
            }
            tarsVet.setSpecialties(tarsSpecialties);
            myvets.add(tarsVet);
        }
        return myvets;
    }
}
