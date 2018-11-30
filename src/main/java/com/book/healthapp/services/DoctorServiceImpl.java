package com.book.healthapp.services;

import com.book.healthapp.domain.Doctor;
import com.book.healthapp.domain.User;
import com.book.healthapp.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository docRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository docRepository) {
        this.docRepository = docRepository;
    }

    @Override
    public void save(Doctor d) {
        docRepository.save(d);
    }

    @Override
    public List<Doctor> findBySpeciality(String s) {
        System.out.println("findBySpeciality - " + s);
        return docRepository.findByIgnoreCaseSpecialityCode(s);
    }

    @Override
    public List<Doctor> findAll() {
        List<Doctor> doctors = new ArrayList<>();
        docRepository.findAll().forEach(doctors::add);
        return doctors;
    }

    @Override
    public Doctor findByUserEmailAddress(String email) {
        return docRepository.findDoctorByUserEmail(email);
    }

    @Override
    public int findCount() {
        return 0;
    }

    @Override
    public Doctor findByUserId(Long id) {
        return docRepository.findDoctorByUserId(id);
    }

    @Override
    public void addDoctor(User u) {

    }
}
