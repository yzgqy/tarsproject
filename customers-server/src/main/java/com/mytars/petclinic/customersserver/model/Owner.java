package com.mytars.petclinic.customersserver.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "owners")
public class Owner {

    public Owner(com.mytars.petclinic.customersserver.tars.customers.Owner tarsOwener){
        this.id = tarsOwener.getId();
        setAddress(tarsOwener.getAddress());
        setCity(tarsOwener.getCity());
        setFirstName(tarsOwener.getFirstName());
        setLastName(tarsOwener.getLastName());
        setTelephone(tarsOwener.getTelephone());
        List<com.mytars.petclinic.customersserver.tars.customers.Pet> tarsPets = tarsOwener.getPets();
        if(tarsPets!=null)
            for(com.mytars.petclinic.customersserver.tars.customers.Pet tarspet:tarsPets){
                addPet(new Pet(tarspet));
            }
    }

    public Owner(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    @NotEmpty
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty
    private String lastName;

    @Column(name = "address")
    @NotEmpty
    private String address;

    @Column(name = "city")
    @NotEmpty
    private String city;

    @Column(name = "telephone")
    @NotEmpty
    @Digits(fraction = 0, integer = 10)
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "owner")
    private Set<Pet> pets;

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    protected Set<Pet> getPetsInternal() {
        if (this.pets == null) {
            this.pets = new HashSet<>();
        }
        return this.pets;
    }

    public List<Pet> getPets() {
        final List<Pet> sortedPets = new ArrayList<>(getPetsInternal());
        PropertyComparator.sort(sortedPets, new MutableSortDefinition("name", true, true));
        return Collections.unmodifiableList(sortedPets);
    }

    public void addPet(Pet pet) {
        getPetsInternal().add(pet);
        pet.setOwner(this);
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)

                .append("id", this.getId())
                .append("lastName", this.getLastName())
                .append("firstName", this.getFirstName())
                .append("address", this.address)
                .append("city", this.city)
                .append("telephone", this.telephone)
                .toString();
    }

    public com.mytars.petclinic.customersserver.tars.customers.Owner toTarsOwner(){
        com.mytars.petclinic.customersserver.tars.customers.Owner tarsOwner = new com.mytars.petclinic.customersserver.tars.customers.Owner();
        tarsOwner.setId(this.id);
        tarsOwner.setAddress(this.address);
        tarsOwner.setCity(this.city);
        tarsOwner.setFirstName(this.firstName);
        tarsOwner.setLastName(this.lastName);
        tarsOwner.setTelephone(this.telephone);
        List<com.mytars.petclinic.customersserver.tars.customers.Pet> tarsPets = new ArrayList<>();
        if(this.pets!=null)
            for(Pet pet:this.pets){
                tarsPets.add(pet.toTarsPet());
            }
        tarsOwner.setPets(tarsPets);

        return tarsOwner;
    }
}
