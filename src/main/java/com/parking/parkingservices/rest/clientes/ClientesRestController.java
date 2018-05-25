package com.parking.parkingservices.rest.clientes;

import com.google.gson.Gson;
import com.parking.parkingservices.factory.ReportFactory;
import com.parking.parkingservices.model.dto.ClientesDTO;
import com.parking.parkingservices.model.entity.Clientes;
import com.parking.parkingservices.model.repository.ClientesRepository;
import com.parking.parkingservices.repository.ClientesRepositoryReport;
import com.parking.parkingservices.rest.pdf.ReporteResController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@CrossOrigin()
@RestController
@RequestMapping("/clientes")
public class ClientesRestController implements IClientesRestController {

    @Autowired
    ClientesRepository clientesRepository;

    @Autowired
    ClientesRepositoryReport clientesRepositoryReport;

    @Autowired
    ReporteResController reporteResController;

    @Autowired
    ReportFactory reportFactory;

    public ResponseEntity<?> findAll() {
        List<ClientesDTO> result = new ArrayList<>();
        try {
            List<Clientes> lista = clientesRepository.findAll();
            for (Clientes clientes : lista) {
                result.add(ClientesDTO.createFromEntity(clientes));
            }
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<?> save(@RequestBody ClientesDTO clientesDTO) {
        try {
            clientesRepository.save(clientesDTO.toEntity());
            return new ResponseEntity<>(clientesDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> reporte(@RequestParam HashMap<String, String> params,
                                     @RequestParam(defaultValue = "PDF") String type,
                                     HttpServletRequest request, HttpSession session,
                                     HttpServletResponse httpServletResponse) {
        try {
            List report = clientesRepositoryReport.getReport(params);
            Gson gson = new Gson();
            String json = gson.toJson(report);
            HashMap<String, Object> parameters = new HashMap<>();
            String reporte = reportFactory.MYACPRINTBODEGAS;
            ResponseEntity<?> response = reporteResController.reportePDF(type, request, json, parameters, reporte, httpServletResponse);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
