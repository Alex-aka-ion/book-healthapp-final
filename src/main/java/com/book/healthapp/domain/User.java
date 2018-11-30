package com.book.healthapp.domain;

import com.book.healthapp.domain.Doctor;
import com.book.healthapp.domain.Rx;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "USER_TABLE")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    @JsonIgnore
    private String password;
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer gender;
    private Integer role;

    /*@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    @JsonBackReference
    private List<Rx> rxes;*/
}