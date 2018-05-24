package com.parking.parkingservices.model.repository;

import com.parking.parkingservices.model.entity.TpVehiculo;
import com.parking.parkingservices.model.entity.Zonas;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TpVehiculoRepository extends PagingAndSortingRepository<TpVehiculo, String> {
    List<TpVehiculo> findAll();

    TpVehiculo save(TpVehiculo tpVehiculo);
}
