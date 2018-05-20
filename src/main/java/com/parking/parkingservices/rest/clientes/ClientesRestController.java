package com.parking.parkingservices.rest.clientes;

import com.parking.parkingservices.model.dto.ClientesDTO;
import com.parking.parkingservices.model.entity.Clientes;
import com.parking.parkingservices.model.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesRestController implements IClientesRestController{

    @Autowired
    ClientesRepository clientesRepository;

    public ResponseEntity<?> findAll(){
        List<ClientesDTO> result = new ArrayList<>();
        try {
            List<Clientes> lista = clientesRepository.findAll();
            for (Clientes clientes : lista) {
                result.add(ClientesDTO.createFromEntity(clientes));
            }
        }catch (Exception e){
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public ResponseEntity<?> save(@RequestBody ClientesDTO clientesDTO) {
        try {
            Clientes clients = clientesRepository.findOne(clientesDTO.getClieCodigo()+"");
            if (clients == null) {
                clientesRepository.save(clientesDTO.toEntity());
                return new ResponseEntity<>(clientesDTO, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<String>(HttpStatus.ALREADY_REPORTED);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
