package com.parking.parkingservices.rest.facturas;

import com.google.gson.Gson;
import com.parking.parkingservices.factory.ReportFactory;
import com.parking.parkingservices.repository.FacturaRepositoryReport;
import com.parking.parkingservices.rest.pdf.ReporteResController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/facturas")
public class FacturasRestController implements IFacturasRestController {

    @Autowired
    FacturaRepositoryReport facturaRepositoryReport;

    @Autowired
    ReporteResController reporteResController;

    @Autowired
    ReportFactory reportFactory;

    public ResponseEntity<?> reporte(@RequestParam HashMap<String, String> params,
                                     @RequestParam(defaultValue = "PDF") String type,
                                     HttpServletRequest request, HttpSession session,
                                     HttpServletResponse httpServletResponse) {
        try {
            List report = facturaRepositoryReport.getReport(params);
            Gson gson = new Gson();
            String json = gson.toJson(report);
            HashMap<String, Object> parameters = new HashMap<>();
            String reporte = reportFactory.FACTURA;
            ResponseEntity<?> response = reporteResController.reportePDF(type, request, json, parameters, reporte, httpServletResponse);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
