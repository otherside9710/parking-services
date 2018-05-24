package com.parking.parkingservices.rest.tpVehiculo;

import com.parking.parkingservices.model.dto.TpVehiculoDTO;
import com.parking.parkingservices.model.dto.VehiculosDTO;
import com.parking.parkingservices.model.entity.TpVehiculo;
import com.parking.parkingservices.model.entity.Vehiculo;
import com.parking.parkingservices.model.repository.TpVehiculoRepository;
import com.parking.parkingservices.model.repository.VehiculoRepository;
import com.parking.parkingservices.rest.pdf.ReporteResController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tpvehiculos")
public class TpVehiculoRestController implements ITpVehiculoRestController {

    @Autowired
    TpVehiculoRepository tpVehiculoRepository;

    public ResponseEntity<?> findAll() {
        List<TpVehiculoDTO> result = new ArrayList<>();
        try {
            List<TpVehiculo> lista = tpVehiculoRepository.findAll();
            for (TpVehiculo tpVehiculo : lista) {
                result.add(TpVehiculoDTO.createFromEntity(tpVehiculo));
            }
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public ResponseEntity<?> save(@RequestBody TpVehiculoDTO tpVehiculoDTO) {
        try {
            TpVehiculo tpVehiculo = tpVehiculoRepository.findOne(tpVehiculoDTO.getTpvCodigo() + "");
            if (tpVehiculo == null) {
                tpVehiculoRepository.save(tpVehiculoDTO.toEntity());
                return new ResponseEntity<>(tpVehiculoDTO, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<String>(HttpStatus.ALREADY_REPORTED);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
