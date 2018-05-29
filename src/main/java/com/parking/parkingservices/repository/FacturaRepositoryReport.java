package com.parking.parkingservices.repository;

import com.parking.parkingservices.repository.base.Query;
import com.parking.parkingservices.repository.base.ReportRepositoryBase;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class FacturaRepositoryReport extends ReportRepositoryBase {

    @Query(value = "SELECT p.par_codigo AS parCodigo,\n" +
            "\t\t\t\tf.fact_codigo AS factura,\n" +
            "\t\t\t\tf.fact_descripcion AS factDescripcion,\n" +
            "\t\t\t\tf.fact_fecha AS factFecha,\n" +
            "\t\t\t\tf.fact_estado AS factEstado,\n" +
            " v.veh_codigo AS vehCodigo,\n" +
            " v.veh_placa AS vehPlaca, \n" +
            " u.usua_nombres as usuaNombre,\n" +
            " u.usua_apellidos as usuaApellidos,\n" +
            "CONVERT(REPLACE(REPLACE(p.par_hinicio, ' ', ''), 'PM', ''), TIME) AS horaInicio,\n" +
            "CONVERT(REPLACE(REPLACE(p.par_hfinal, ' ', ''), 'PM', ''), TIME) AS horaFinal,\n" +
            "TIMEDIFF(CONVERT(REPLACE(REPLACE(p.par_hinicio, ' ', ''), 'PM', ''), TIME),CONVERT(REPLACE(REPLACE(p.par_hfinal, ' ', ''), 'PM', ''), TIME)) as totalHora,\n" +
            "\n" +
            "cast(time_to_sec(TIMEDIFF(CONVERT(REPLACE(REPLACE(p.par_hinicio, ' ', ''), 'PM', ''), TIME),CONVERT(REPLACE(REPLACE(p.par_hfinal, ' ', ''), 'PM', ''), TIME))) / (60 * 60) as decimal(10,2)) * 2000 as valor,\n" +
            " p.usua_codigo AS UsuaCodigo,\n" +
            " p.zona_codigo AS zona,\n" +
            " p.par_observacion AS observacion, \n" +
            " c.clie_codigo AS clieCodigo,\n" +
            " c.clie_nombres AS clieNombres,\n" +
            " c.clie_apellidos AS clieApellidos,\n" +
            " c.clie_cedula AS clieCedula,\n" +
            " t.ticket_codigo AS ticketCodigo\n" +
            "FROM facturas f\n" +
            "LEFT JOIN ticket t ON t.ticket_codigo = f.ticket_codigo\n" +
            "LEFT JOIN parqueo p ON p.par_codigo = t.par_codigo\n" +
            "LEFT JOIN vehiculo v ON v.veh_codigo = p.veh_codigo\n" +
            "LEFT JOIN clientes c ON c.clie_codigo = v.clie_codigo\n" +
            "LEFT JOIN usuarios u ON u.usua_codigo = p.usua_codigo\n" +
            "WHERE t.ticket_codigo = ::ticketCodigo")

    @Override
    public String getQuery(String query, HashMap<String, String> params) {
        String ticketCodigo = "";
        if (params.containsKey("ticketCodigo")){
            ticketCodigo = params.get("ticketCodigo");
        }
        params.put("ticketCodigo", ticketCodigo);
        return query;
    }
}
