package com.parking.parkingservices.rest.fabrica;

import com.parking.parkingservices.model.dto.ClientesDTO;
import com.parking.parkingservices.model.dto.ClientesVsVehiculos;

import com.parking.parkingservices.model.dto.VehiculosDTO;
import com.parking.parkingservices.model.repository.*;
import com.parking.parkingservices.rest.clientes.ClientesRestController;
import com.parking.parkingservices.rest.vehiculo.VehiculoRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@CrossOrigin()
@RestController
@RequestMapping("/fabrica")
public class FabricaRestController implements IFabricaRestController {

    @Autowired
    ClientesRestController clientesRestController;

    @Autowired
    VehiculoRestController vehiculoRestController;

    @Autowired
    ClientesRepository clientesRepository;

    @Autowired
    VehiculoRepository vehiculoRepository;

    @Autowired
    ZonasRepository zonasRepository;

    @Autowired
    ParqueoRepository parqueoRepository;

    @Autowired
    UsuariosRepository usuariosRepository;

    @Autowired
    FacturasRepository facturasRepository;

    public ResponseEntity<?> transaction(@RequestBody ClientesVsVehiculos cv) {
        try {

            String code = clientesRepository.maxCode();
            Integer maxCode = Integer.parseInt(code);

            ClientesDTO clientesDTO = new ClientesDTO();
            clientesDTO.setClieCodigo(maxCode + 1);
            clientesDTO.setClieNombres(cv.getClieNombres());
            clientesDTO.setClieApellidos(cv.getClieApellidos());
            clientesDTO.setClieCedula(cv.getClieCedula());
            clientesDTO.setClieTelefono(cv.getClieTelefono());
            clientesDTO.setClieCiudad(cv.getClieCiudad());
            clientesDTO.setClieDireccion(cv.getClieDireccion());
            clientesDTO.setClieEmail(cv.getClieEmail());
            clientesDTO.setClieEstado(cv.getClieEstado());

            VehiculosDTO vehiculosDTO = new VehiculosDTO();
            vehiculosDTO.setVehCodigo(cv.getVehCodigo());
            vehiculosDTO.setVehPlaca(cv.getVehPlaca());
            vehiculosDTO.setVehEstado(cv.getVehEstado());
            vehiculosDTO.setZonaCodigo(cv.getZonaCodigo());
            vehiculosDTO.setTpvCodigo(cv.getTpvCodigo());
            vehiculosDTO.setClieCodigo(maxCode + 1);

            clientesRestController.save(clientesDTO);
            vehiculoRestController.save(vehiculosDTO);

        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(cv, HttpStatus.OK);
    }

    public ResponseEntity<?> getMax() {
        HashMap<String, String> params = new HashMap<>();
        try {
            String clientes = clientesRepository.maxCount();
            String vehiculo = vehiculoRepository.maxCount();
            String zonas = zonasRepository.maxCount();
            String parqueo = parqueoRepository.maxCount();
            String usuarios = usuariosRepository.maxCount();
            String facturas = facturasRepository.maxCount();

            params.put("clientes", clientes);
            params.put("vehiculo", vehiculo);
            params.put("zonas", zonas);
            params.put("parqueo", parqueo);
            params.put("usuarios", usuarios);
            params.put("facturas", facturas);

        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(params, HttpStatus.OK);
    }

}
