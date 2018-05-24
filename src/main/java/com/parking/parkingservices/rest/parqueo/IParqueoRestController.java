package com.parking.parkingservices.rest.parqueo;

import com.parking.parkingservices.model.dto.ParqueoDTO;
import com.parking.parkingservices.model.dto.UsuariosDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface IParqueoRestController {
    @RequestMapping(value = "/findAll", produces = { "application/json" }, method = RequestMethod.GET)
    ResponseEntity<?> findAll();

    @RequestMapping(value = "/add", produces = { "application/json" }, method = RequestMethod.POST)
    ResponseEntity<?> save(ParqueoDTO parqueoDTO);
}
