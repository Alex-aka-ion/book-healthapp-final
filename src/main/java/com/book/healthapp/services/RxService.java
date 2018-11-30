package com.book.healthapp.services;

import com.book.healthapp.domain.Rx;

import java.util.List;

public interface RxService {
    void save(Rx rx);

    List<Rx> findByDoctorId(Long id);

    List<Rx> findByUserId(Long id);
}
