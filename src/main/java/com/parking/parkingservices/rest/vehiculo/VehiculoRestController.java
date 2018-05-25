package com.parking.parkingservices.rest.vehiculo;

import com.parking.parkingservices.model.dto.VehiculosDTO;
import com.parking.parkingservices.model.entity.Vehiculo;
import com.parking.parkingservices.model.repository.VehiculoRepository;
import com.parking.parkingservices.rest.pdf.ReporteResController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin()
@RestController
@RequestMapping("/vehiculos")
public class VehiculoRestController implements IVehiculoRestController {

    @Autowired
    VehiculoRepository vehiculoRepository;

    @Autowired
    ReporteResController reporteResController;

    public ResponseEntity<?> findAll() {
        List<VehiculosDTO> result = new ArrayList<>();
        try {
            List<Vehiculo> lista = vehiculoRepository.findAll();
            for (Vehiculo vehiculo : lista) {
                result.add(VehiculosDTO.createFromEntity(vehiculo));
            }
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<?> save(@RequestBody VehiculosDTO vehiculosDto) {
        try {
            vehiculoRepository.save(vehiculosDto.toEntity());
            return new ResponseEntity<>(vehiculosDto, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
