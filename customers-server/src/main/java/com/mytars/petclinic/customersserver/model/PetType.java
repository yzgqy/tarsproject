package com.mytars.petclinic.customersserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "types")
public class PetType {
    public PetType(com.mytars.petclinic.customersserver.tars.customers.PetType tarsType){
        setId(tarsType.getId());
        setName(tarsType.getName());
    }
    public PetType(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    public void setName(final String name) {
        this.name = name;
    }

    public com.mytars.petclinic.customersserver.tars.customers.PetType toTarsType(){
        com.mytars.petclinic.customersserver.tars.customers.PetType tarsType = new com.mytars.petclinic.customersserver.tars.customers.PetType();
        tarsType.setId(this.id);
        tarsType.setName(this.name);
        return tarsType;
    }
}