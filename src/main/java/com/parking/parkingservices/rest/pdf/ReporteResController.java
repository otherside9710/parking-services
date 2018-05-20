package com.parking.parkingservices.rest.pdf;

import com.parking.parkingservices.factory.ReportFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@RestController
@RequestMapping("/reporte")
public class ReporteResController implements IReportRestController {

    @Autowired
    ReportFactory reportFactory;

    public ResponseEntity<?> reportePDF(
            @RequestParam(defaultValue = "PDF") String type,
            HttpServletRequest request, String rawJsonData,
            HashMap<String, Object> parameters,
            String report, HttpServletResponse response){
        try {
            if (type.equals("PDF")) {
                reportFactory.makeFactory(response, request, parameters, report, rawJsonData, ReportFactory.PDF_FORMAT);
            } else {
                reportFactory.makeFactory(response, request, parameters, report, rawJsonData, ReportFactory.XLS_FORMAT);
            }
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return new ResponseEntity<>(rawJsonData, HttpStatus.OK);
    }
}
