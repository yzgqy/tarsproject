package com.mytars.petclinic.visitsserver.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: yaya
 * @Date: 2019/6/17 21:51
 * @Description:
 */
@Entity
@Table(name = "visits")
@Builder(builderMethodName = "visit")
@NoArgsConstructor
@AllArgsConstructor
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Builder.Default
    @Column(name = "visit_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date = new Date();

    @Size(max = 8192)
    @Column(name = "description")
    private String description;

    @Column(name = "pet_id")
    private int petId;

    public Integer getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public int getPetId() {
        return petId;
    }


    public void setPetId(final int petId) {
        this.petId = petId;
    }

    public void setDate(final String  date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.date = simpleDateFormat.parse(date);
            System.out.println(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDescription(final String description) {
        this.description = description;
    }


}
