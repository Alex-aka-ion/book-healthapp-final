package com.book.healthapp.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "RX")
public class Rx {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String symptoms;
    private String medicine;
    private Date createTime;
    private Date lastUpdate;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    @JsonManagedReference
    private User user;

    @ManyToOne
    @JoinColumn(name="DOCTOR_ID")
    @JsonManagedReference
    private Doctor doctor;

    public Rx () {

    }

    public Rx (String symptoms, String medicine, User u, Doctor d) {
        setSymptoms(symptoms);
        setMedicine(medicine);
        setUser(u);
        setDoctor(d);
        setCreateTime(new Date());
        setLastUpdate(new Date());
    }
}
