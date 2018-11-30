package com.book.healthapp.repositories;

import com.book.healthapp.domain.Doctor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
    List<Doctor> findByIgnoreCaseSpecialityCode(String specialityCode);
    Doctor findDoctorByUserId(Long id);
    Doctor findDoctorByUserEmail(String email);
}
