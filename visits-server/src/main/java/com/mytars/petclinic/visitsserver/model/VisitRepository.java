package com.mytars.petclinic.visitsserver.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: yaya
 * @Date: 2019/6/17 21:51
 * @Description:
 */
public interface VisitRepository extends JpaRepository<Visit, Integer> {

    List<Visit> findByPetId(int petId);

    List<Visit> findByPetIdIn(Iterable<Integer> petIds);
}
