package com.book.healthapp.repositories;

import com.book.healthapp.domain.Rx;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RxRepository extends CrudRepository<Rx, Long> {
    List<Rx> findByDoctorId(Long id);
    List<Rx> findByUserId(Long id);
}
