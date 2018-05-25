package com.parking.parkingservices.rest.zonas;

import com.parking.parkingservices.model.dto.ParqueoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface IZonasRestController {
    @RequestMapping(value = "/findAll", produces = { "application/json" }, method = RequestMethod.GET)
    ResponseEntity<?> findAll();
}
