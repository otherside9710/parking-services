package com.parking.parkingservices.rest.pdf;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public interface IReportRestController {
    @RequestMapping(value = "/pdf", produces = { "application/json" }, method = RequestMethod.POST)
    ResponseEntity<?> reportePDF(
            @RequestParam(defaultValue = "PDF") String type,
            HttpServletRequest request, String rawJsonData,
            HashMap<String, Object> parameters,
            String report, HttpServletResponse response
    );
}
