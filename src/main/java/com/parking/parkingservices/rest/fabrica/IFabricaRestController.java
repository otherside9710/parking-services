package com.parking.parkingservices.rest.fabrica;

import com.parking.parkingservices.model.dto.ClientesVsVehiculos;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface IFabricaRestController {
    @RequestMapping(value = "/transaction", produces = { "application/json" }, method = RequestMethod.POST)
    ResponseEntity<?> transaction(@RequestBody ClientesVsVehiculos cv);
}
