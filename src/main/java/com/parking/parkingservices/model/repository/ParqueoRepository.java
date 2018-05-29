package com.parking.parkingservices.model.repository;

import com.parking.parkingservices.model.entity.Parqueo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ParqueoRepository extends PagingAndSortingRepository<Parqueo, String> {
    List<Parqueo> findAll();

    Parqueo save(Parqueo parqueo);

    @Query(value = "SELECT max (p.parCodigo) from Parqueo p")
    String maxCode();

    @Query(value = "SELECT concat(c.clie_nombres, ' ', c.clie_apellidos) as name\n" +
            "FROM parqueo p\n" +
            "LEFT JOIN vehiculo v ON p.veh_codigo = v .veh_codigo\n" +
            "LEFT JOIN clientes c ON v.clie_codigo = c.clie_codigo \n" +
            "where p.par_codigo = ?1", nativeQuery = true)
    String nombre(int parCodigo);

    @Query(value = "SELECT count(p.parCodigo) from Parqueo p")
    String maxCount();
}
