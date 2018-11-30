package com.book.healthapp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "DOCTOR")
public class Doctor {
    @Id
    @GeneratedValue
    private Long id;
    private String specialityCode;
    private Date createTime;
    private Date lastUpdate;

    @OneToOne
    @JoinColumn(name="USER_ID")
    @JsonManagedReference
    private User user;

    /*@OneToMany(mappedBy = "doctor", cascade = CascadeType.PERSIST)
    @JsonBackReference
    private List<Rx> rxes;*/

}
