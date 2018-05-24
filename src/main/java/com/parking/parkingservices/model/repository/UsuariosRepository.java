package com.parking.parkingservices.model.repository;

import com.parking.parkingservices.model.entity.Usuarios;
import com.parking.parkingservices.model.entity.Vehiculo;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UsuariosRepository extends PagingAndSortingRepository<Usuarios, String> {
    List<Usuarios> findAll();

    Usuarios save(Usuarios usuarios);
}
