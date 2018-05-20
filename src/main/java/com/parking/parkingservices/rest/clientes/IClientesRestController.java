package com.parking.parkingservices.rest.clientes;

import com.parking.parkingservices.model.dto.ClientesDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface IClientesRestController {
    @RequestMapping(value = "/findAll", produces = { "application/json" }, method = RequestMethod.GET)
    ResponseEntity<?> findAll();

    @RequestMapping(value = "/add", produces = { "application/json" }, method = RequestMethod.POST)
    ResponseEntity<?> save(ClientesDTO clientesDTO);
}
