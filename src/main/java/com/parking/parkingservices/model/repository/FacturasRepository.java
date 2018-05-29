package com.parking.parkingservices.model.repository;

import com.parking.parkingservices.model.entity.Facturas;
import com.parking.parkingservices.model.entity.Parqueo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface FacturasRepository extends PagingAndSortingRepository<Facturas, String> {
    List<Facturas> findAll();

    Facturas save(Facturas facturas);

    @Query(value = "select max(factCodigo) from Facturas")
    String maxFactura();

}
