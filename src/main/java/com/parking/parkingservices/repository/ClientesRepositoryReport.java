package com.parking.parkingservices.repository;

import com.parking.parkingservices.repository.base.Query;
import com.parking.parkingservices.repository.base.ReportRepositoryBase;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ClientesRepositoryReport extends ReportRepositoryBase {

    @Query(value = "select * from clientes")

    @Override
    public String getQuery(String query, HashMap<String, String> params) {
        return query;
    }
}
