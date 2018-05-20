package com.parking.parkingservices.model.repository;

import com.parking.parkingservices.model.entity.Clientes;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ClientesRepository extends PagingAndSortingRepository<Clientes, String> {
    List<Clientes> findAll();

    Clientes save(Clientes clientes);
}
