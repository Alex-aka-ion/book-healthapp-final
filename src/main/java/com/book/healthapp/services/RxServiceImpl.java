package com.book.healthapp.services;

import com.book.healthapp.domain.Rx;
import com.book.healthapp.repositories.RxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RxServiceImpl implements RxService {
    private final RxRepository rxRepository;

    @Autowired
    public RxServiceImpl(RxRepository rxRepository) {
        this.rxRepository = rxRepository;
    }

    @Override
    public void save(Rx rx) {
        rxRepository.save(rx);
    }

    @Override
    public List<Rx> findByDoctorId(Long id) {
        return rxRepository.findByDoctorId(id);
    }

    @Override
    public List<Rx> findByUserId(Long id) {
        return rxRepository.findByUserId(id);
    }
}
