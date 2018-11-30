package com.book.healthapp.controllers;

import com.book.healthapp.helpers.RxDTO;
import com.book.healthapp.domain.Doctor;
import com.book.healthapp.domain.Rx;
import com.book.healthapp.domain.User;
import com.book.healthapp.services.DoctorService;
import com.book.healthapp.services.RxService;
import com.book.healthapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rx")
public class RxController {
    @Autowired
    private RxService rxService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private UserService userService;

    @GetMapping
    public List<RxDTO> getRx() {
        List<Rx> rxes;
        User user = getUser();
        if(user.getRole() == 1) {
            System.out.println("FindByDoctorId");
            Doctor d = doctorService.findByUserEmailAddress(getUserEmailAddress());
            rxes = rxService.findByDoctorId(d.getId());
        } else {
            System.out.println("FindByUserId");
            rxes = rxService.findByUserId(user.getId());
        }
        List<RxDTO> rxDTOS = new ArrayList<>();
        for (Rx rx: rxes) {
            RxDTO tmprxdto = new RxDTO();
            tmprxdto.setPatientId(rx.getUser().getEmail());
            tmprxdto.setPatientName(rx.getUser().getFirstName() + " " + rx.getUser().getLastName());
            tmprxdto.setMedicine(rx.getMedicine());
            tmprxdto.setSymptoms(rx.getSymptoms());
            rxDTOS.add(tmprxdto);
        }
        return rxDTOS;
    }

    @PostMapping(value="/new", produces="application/json")
    public Rx createRx(@RequestBody RxDTO rxdto) {
        System.out.println("createRx");
        User u = userService.getByEmail(rxdto.getPatientId());
        Doctor d = doctorService.findByUserEmailAddress(getUserEmailAddress());
        Rx rx = new Rx(
                rxdto.getSymptoms(),
                rxdto.getMedicine(),
                u,
                d
        );
        rxService.save(rx);
        return rx;
    }

    private User getUser() {
        return userService.doesUserExist(getUserEmailAddress());
    }

    private String getUserEmailAddress() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println(userDetails);
        return userDetails.getUsername();
    }
}
