package com.parking.parkingservices.rest.usuarios;

import com.parking.parkingservices.model.dto.UsuariosDTO;
import com.parking.parkingservices.model.dto.VehiculosDTO;
import com.parking.parkingservices.model.entity.Usuarios;
import com.parking.parkingservices.model.entity.Vehiculo;
import com.parking.parkingservices.model.repository.UsuariosRepository;
import com.parking.parkingservices.model.repository.VehiculoRepository;
import com.parking.parkingservices.rest.pdf.ReporteResController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/usuarios")
public class UsuariosRestController implements IUsuariosRestController {

    @Autowired
    UsuariosRepository usuariosRepository;

    @Autowired
    ReporteResController reporteResController;

    public ResponseEntity<?> findAll() {
        List<UsuariosDTO> result = new ArrayList<>();
        try {
            List<Usuarios> lista = usuariosRepository.findAll();
            for (Usuarios usuarios : lista) {
                result.add(UsuariosDTO.createFromEntity(usuarios));
            }
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public ResponseEntity<?> save(@RequestBody UsuariosDTO usuariosDTO) {
        try {
            usuariosRepository.save(usuariosDTO.toEntity());
            return new ResponseEntity<>(usuariosDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> login(@RequestBody HashMap<String, String> params){
        try {
            if (params.containsKey("usuaCedula") && params.containsKey("usuaPassword")){
                String cedula = params.get("usuaCedula");
                String pass = params.get("usuaPassword");

                usuariosRepository.findOne();

            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }


}
