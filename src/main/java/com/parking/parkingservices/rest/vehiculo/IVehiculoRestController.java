package com.parking.parkingservices.rest.vehiculo;

import com.parking.parkingservices.model.dto.VehiculosDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface IVehiculoRestController {
    @RequestMapping(value = "/findAll", produces = { "application/json" }, method = RequestMethod.GET)
    ResponseEntity<?> findAll();

    @RequestMapping(value = "/add", produces = { "application/json" }, method = RequestMethod.POST)
    ResponseEntity<?> save(VehiculosDTO vehiculosDto);
}
