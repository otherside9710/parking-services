package com.parking.parkingservices.rest.ticket;

import com.parking.parkingservices.model.dto.TickectDTO;
import com.parking.parkingservices.model.dto.VehiculosDTO;
import com.parking.parkingservices.model.entity.Ticket;
import com.parking.parkingservices.model.entity.Vehiculo;
import com.parking.parkingservices.model.repository.TicketRepository;
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
import java.util.List;
@CrossOrigin()
@RestController
@RequestMapping("/tickets")
public class TicketRestController implements ITicketRestController {

    @Autowired
    TicketRepository ticketRepository;

    public ResponseEntity<?> findAll() {
        List<TickectDTO> result = new ArrayList<>();
        try {
            List<Ticket> lista = ticketRepository.findAll();
            for (Ticket ticket : lista) {
                result.add(TickectDTO.createFromEntity(ticket));
            }
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public ResponseEntity<?> save(@RequestBody TickectDTO tickectDTO) {
        try {
            Ticket ticket = ticketRepository.findOne(tickectDTO.getTicketCodigo() + "");
            if (ticket == null) {
                ticketRepository.save(tickectDTO.toEntity());
                return new ResponseEntity<>(tickectDTO, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<String>(HttpStatus.ALREADY_REPORTED);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
