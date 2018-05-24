package com.parking.parkingservices.rest.roles;

import com.parking.parkingservices.model.dto.RolesDTO;
import com.parking.parkingservices.model.dto.VehiculosDTO;
import com.parking.parkingservices.model.entity.Roles;
import com.parking.parkingservices.model.entity.Vehiculo;
import com.parking.parkingservices.model.repository.RolesRepository;
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
@RequestMapping("/roles")
public class RolesRestController implements IRolesRestController {

    @Autowired
    RolesRepository rolesRepository;

    public ResponseEntity<?> findAll() {
        List<RolesDTO> result = new ArrayList<>();
        try {
            List<Roles> lista = rolesRepository.findAll();
            for (Roles roles : lista) {
                result.add(RolesDTO.createFromEntity(roles));
            }
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public ResponseEntity<?> save(@RequestBody RolesDTO rolesDTO) {
        try {
            Roles roles = rolesRepository.findOne(rolesDTO.getRolCodigo() + "");
            if (roles == null) {
                rolesRepository.save(rolesDTO.toEntity());
                return new ResponseEntity<>(rolesDTO, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<String>(HttpStatus.ALREADY_REPORTED);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
