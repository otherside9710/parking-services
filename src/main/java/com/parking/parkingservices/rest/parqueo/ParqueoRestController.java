package com.parking.parkingservices.rest.parqueo;

import com.parking.parkingservices.model.dto.ParqueoDTO;
import com.parking.parkingservices.model.dto.UsuariosDTO;
import com.parking.parkingservices.model.entity.Parqueo;
import com.parking.parkingservices.model.entity.Usuarios;
import com.parking.parkingservices.model.repository.ParqueoRepository;
import com.parking.parkingservices.model.repository.UsuariosRepository;
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
@RequestMapping("/parqueo")
public class ParqueoRestController implements IParqueoRestController {

    @Autowired
    ParqueoRepository parqueoRepository;

    public ResponseEntity<?> findAll() {
        List<ParqueoDTO> result = new ArrayList<>();
        try {
            List<Parqueo> lista = parqueoRepository.findAll();
            for (Parqueo parqueo : lista) {
                result.add(ParqueoDTO.createFromEntity(parqueo));
            }
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public ResponseEntity<?> save(@RequestBody ParqueoDTO parqueoDTO) {
        try {
            Parqueo usuarios = parqueoRepository.findOne(parqueoDTO.getParCodigo() + "");
            if (usuarios == null) {
                parqueoRepository.save(parqueoDTO.toEntity());
                return new ResponseEntity<>(parqueoDTO, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<String>(HttpStatus.ALREADY_REPORTED);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
