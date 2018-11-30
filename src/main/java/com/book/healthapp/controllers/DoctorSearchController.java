package com.book.healthapp.controllers;

import com.book.healthapp.helpers.DoctorInfo;
import com.book.healthapp.domain.Doctor;
import com.book.healthapp.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorSearchController {
    @Autowired
    private DoctorService docService;

    @GetMapping(produces = {"application/json"})
    public DoctorInfo findAll() {
        return new DoctorInfo("нашлось все", docService.findAll());
    }

    @GetMapping(value = "/{code}", produces = {"application/json"})
    public DoctorInfo getBySpecialityCode(@PathVariable("code") String code) {
        return new DoctorInfo("нашлось", docService.findBySpeciality(code));
    }

    @GetMapping(value = "/id/{id}", produces = {"application/json"})
    public Doctor getBySpecialityCode(@PathVariable("id") Long id) {
        return docService.findByUserId(id);
    }

}
