package com.parking.parkingservices.model.repository;

import com.parking.parkingservices.model.entity.Vehiculo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface VehiculoRepository extends PagingAndSortingRepository<Vehiculo, String> {
    List<Vehiculo> findAll();

    @Query(value = "SELECT max (v.vehCodigo) from Vehiculo v")
    String maxCode();

    Vehiculo save(Vehiculo vehiculo);
}
