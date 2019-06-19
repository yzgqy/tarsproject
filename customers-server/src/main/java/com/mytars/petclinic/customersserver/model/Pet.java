package com.mytars.petclinic.customersserver.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "pets")
public class Pet {
    public Pet(){

    }

    public Pet(com.mytars.petclinic.customersserver.tars.customers.Pet tarsPet){
        this.id = tarsPet.getId();
        com.mytars.petclinic.customersserver.tars.customers.PetType tarsType = tarsPet.getPetType();
        if(tarsType == null)
            setType(null);
        else
            setType(new PetType(tarsPet.getPetType()));
        setName(tarsPet.getName());
        setBirthDate(tarsPet.getBirthDate());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType type;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonIgnore
    private Owner owner;

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(final String birthDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.birthDate = simpleDateFormat.parse(birthDate);
//            System.out.println(birthDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setBirthDate(final Date birthDate) {
        this.birthDate = birthDate;
    }
    public PetType getType() {
        return type;
    }

    public void setType(final PetType type) {
        this.type = type;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(final Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("id", this.getId())
                .append("name", this.getName())
                .append("birthDate", this.getBirthDate())
                .append("type", this.getType().getName())
                .append("ownerFirstname", this.getOwner().getFirstName())
                .append("ownerLastname", this.getOwner().getLastName())
                .toString();
    }

    public com.mytars.petclinic.customersserver.tars.customers.Pet toTarsPet(){
        com.mytars.petclinic.customersserver.tars.customers.Pet tarsPet = new com.mytars.petclinic.customersserver.tars.customers.Pet();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(this.birthDate);
        tarsPet.setBirthDate(dateString);
        tarsPet.setId(this.id);
        tarsPet.setName(this.name);
        if(this.type!=null)
            tarsPet.setPetType(this.type.toTarsType());
        else
            tarsPet.setPetType(null);
        return tarsPet;
    }
}

