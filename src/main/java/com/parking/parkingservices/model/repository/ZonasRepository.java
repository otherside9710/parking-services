package com.parking.parkingservices.model.repository;

import com.parking.parkingservices.model.entity.Zonas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ZonasRepository extends PagingAndSortingRepository<Zonas, String> {
    List<Zonas> findAll();

    Zonas save(Zonas zonas);

    @Query(value = "select max(z.zonaCodigo) from Zonas z")
    String maxZonas();
}
