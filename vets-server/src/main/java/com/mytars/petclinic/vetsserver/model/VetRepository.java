package com.mytars.petclinic.vetsserver.model;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: yaya
 * @Date: 2019/6/17 14:50
 * @Description:
 */
public interface VetRepository extends JpaRepository<Vet, Integer> {
}
