package com.mytars.petclinic.customersserver.web;

import com.mytars.petclinic.customersserver.model.Pet;
import com.mytars.petclinic.customersserver.model.PetType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class PetDetails {

    private long id;

    private String name;

    private String owner;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    private PetType type;

    public PetDetails(Pet pet) {
        this.id = pet.getId();
        this.name = pet.getName();
        this.owner = pet.getOwner().getFirstName() + " " + pet.getOwner().getLastName();
        this.birthDate = pet.getBirthDate();
        this.type = pet.getType();
    }

    public com.mytars.petclinic.customersserver.tars.customers.PetDetails toTarsPetDetail(){
        com.mytars.petclinic.customersserver.tars.customers.PetDetails tarsPetDetail = new com.mytars.petclinic.customersserver.tars.customers.PetDetails();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(this.birthDate);
        tarsPetDetail.setBirthDate(dateString);
        tarsPetDetail.setId((int) this.id);
        tarsPetDetail.setName(this.name);
        tarsPetDetail.setOwner(this.owner);
        if(this.type!=null)
            tarsPetDetail.setType(this.type.toTarsType());
        else
            tarsPetDetail.setType(null);
        return tarsPetDetail;
    }
}