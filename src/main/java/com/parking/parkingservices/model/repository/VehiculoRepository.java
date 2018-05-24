package com.parking.parkingservices.model.repository;

import com.parking.parkingservices.model.entity.Vehiculo;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface VehiculoRepository extends PagingAndSortingRepository<Vehiculo, String> {
    List<Vehiculo> findAll();

    Vehiculo save(Vehiculo vehiculo);
}
