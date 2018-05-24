package com.parking.parkingservices.model.repository;

import com.parking.parkingservices.model.entity.Roles;
import com.parking.parkingservices.model.entity.Vehiculo;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RolesRepository extends PagingAndSortingRepository<Roles, String> {
    List<Roles> findAll();

    Roles save(Roles roles);
}
