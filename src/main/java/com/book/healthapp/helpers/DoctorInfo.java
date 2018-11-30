package com.book.healthapp.helpers;

import com.book.healthapp.domain.Doctor;
import lombok.Data;

import java.util.List;

@Data
public class DoctorInfo {
    private List<Doctor> doctors;
    private String message;
    private int count;

    public DoctorInfo() {}

    public DoctorInfo(String message, List<Doctor> doctors) {
        setMessage(message);
        setDoctors(doctors);
        setCount(doctors.size());
    }

    public DoctorInfo(String message, int count) {
        setMessage(message);
        setCount(count);
    }
}
