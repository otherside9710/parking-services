package com.parking.parkingservices.model.repository;

import com.parking.parkingservices.model.entity.Roles;
import com.parking.parkingservices.model.entity.Zonas;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ZonasRepository extends PagingAndSortingRepository<Zonas, String> {
    List<Zonas> findAll();

    Zonas save(Zonas zonas);
}
