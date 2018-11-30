package com.book.healthapp.services;

import com.book.healthapp.domain.Doctor;
import com.book.healthapp.domain.User;

import java.util.List;

public interface DoctorService {
    void save(Doctor d);

    List<Doctor> findBySpeciality(String s);

    List<Doctor> findAll();

    Doctor findByUserEmailAddress(String email);

    int findCount();

    Doctor findByUserId(Long id);

    void addDoctor(User u);
}
