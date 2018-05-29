package com.parking.parkingservices.model.repository;

import com.parking.parkingservices.model.entity.Facturas;
import com.parking.parkingservices.model.entity.Parqueo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface FacturasRepository extends PagingAndSortingRepository<Facturas, String> {
    List<Facturas> findAll();

    Facturas save(Facturas facturas);

    @Query(value = "SELECT p.par_codigo as parCodigo,\n" +
            "v.veh_codigo as vehCodigo,\n" +
            "v.veh_placa as vehPlaca,\n" +
            "p.par_hinicio as hraIncio,\n" +
            "p.par_hfinal as HraFinal,\n" +
            "p.usua_codigo as UsuaCodigo,\n" +
            "p.zona_codigo as zona,\n" +
            "p.par_observacion as observacion, \n" +
            "c.clie_codigo as clieCodigo,\n" +
            "c.clie_nombres as clieNombres,\n" +
            "c.clie_apellidos as clieApellidos,\n" +
            "c.clie_cedula as clieCedula,\n" +
            "t.ticket_codigo as ticketCodigo\n" +
            "FROM facturas f\n" +
            "LEFT JOIN ticket t ON t.ticket_codigo = f.ticket_codigo\n" +
            "LEFT JOIN parqueo p ON p.par_codigo = t.par_codigo\n" +
            "LEFT JOIN vehiculo v ON v.veh_codigo = p.veh_codigo\n" +
            "LEFT JOIN clientes c ON c.clie_codigo = v.clie_codigo\n" +
            "where t.ticket_codigo = ?1", nativeQuery = true)
    List<String> getFacturaByTicket(int ticket);
}
