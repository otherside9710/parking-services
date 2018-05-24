package com.parking.parkingservices.model.repository;

import com.parking.parkingservices.model.entity.Parqueo;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ParqueoRepository extends PagingAndSortingRepository<Parqueo, String> {
    List<Parqueo> findAll();

    Parqueo save(Parqueo parqueo);
}
