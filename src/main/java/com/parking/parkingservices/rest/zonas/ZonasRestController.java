package com.parking.parkingservices.rest.zonas;

import com.parking.parkingservices.model.dto.ZonasDTO;
import com.parking.parkingservices.model.entity.Zonas;
import com.parking.parkingservices.model.repository.ZonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin()
@RestController
@RequestMapping("/zonas")
public class ZonasRestController implements IZonasRestController {

    @Autowired
    ZonasRepository zonasRepository;

    public ResponseEntity<?> findAll() {
        List<ZonasDTO> result = new ArrayList<>();
        try {
            List<Zonas> lista = zonasRepository.findAll();
            for (Zonas zonas : lista) {
                result.add(ZonasDTO.createFromEntity(zonas));
            }
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    public ResponseEntity<?> save(@RequestBody ZonasDTO zonasDTO) {
        try {
            zonasRepository.save(zonasDTO.toEntity());
            return new ResponseEntity<>(zonasDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
