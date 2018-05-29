package com.parking.parkingservices.rest.facturas;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

public interface IFacturasRestController {
    @RequestMapping(value = "/reportPdf", produces = { "application/json" }, method = RequestMethod.GET)
    ResponseEntity<?> reporte(@RequestParam HashMap<String, String> params,
                              @RequestParam(defaultValue = "PDF") String type,
                              HttpServletRequest request, HttpSession session,
                              HttpServletResponse httpServletResponse);
}
