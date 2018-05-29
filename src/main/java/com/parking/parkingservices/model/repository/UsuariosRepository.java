package com.parking.parkingservices.model.repository;

import com.parking.parkingservices.model.entity.Usuarios;
import com.parking.parkingservices.model.entity.Vehiculo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UsuariosRepository extends PagingAndSortingRepository<Usuarios, String> {
    List<Usuarios> findAll();

    Usuarios save(Usuarios usuarios);

    @Query(value = "SELECT max (u.usuaCodigo) from Usuarios u")
    String maxCode();

    @Query(value = "SELECT count(u.usuaCodigo) from Usuarios u")
    String maxCount();

    @Query(value = "select usua_codigo, concat(u.usua_nombres, ' ', u.usua_apellidos) as name from usuarios u where u.usua_cedula=?1 and u.usua_password = ?2", nativeQuery = true)
    List<String> findUsuaByCedulaAndPass(String cedula, String  pass);
}
