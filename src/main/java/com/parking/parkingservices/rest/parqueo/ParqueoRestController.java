package com.parking.parkingservices.rest.parqueo;

import com.parking.parkingservices.model.dto.ParqueoDTO;
import com.parking.parkingservices.model.dto.TickectDTO;
import com.parking.parkingservices.model.dto.UsuariosDTO;
import com.parking.parkingservices.model.entity.Parqueo;
import com.parking.parkingservices.model.entity.Ticket;
import com.parking.parkingservices.model.entity.TicketPK;
import com.parking.parkingservices.model.entity.Usuarios;
import com.parking.parkingservices.model.repository.ParqueoRepository;
import com.parking.parkingservices.model.repository.TicketRepository;
import com.parking.parkingservices.model.repository.UsuariosRepository;
import com.parking.parkingservices.rest.pdf.ReporteResController;
import com.parking.parkingservices.rest.ticket.TicketRestController;
import io.swagger.models.auth.In;
import javassist.expr.Instanceof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/parqueo")
public class ParqueoRestController implements IParqueoRestController {

    @Autowired
    ParqueoRepository parqueoRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    TicketRestController ticketRestController;

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
            String lastCode = parqueoRepository.maxCode();
            String lastTicket  = ticketRepository.maxCode();
            int maxCode = Integer.valueOf(lastCode) + 1;
            int maxCodeTicket = Integer.valueOf(lastTicket) + 1;

            TickectDTO ticket = new TickectDTO();

            ticket.setParCodigo(maxCode);
            ticket.setTicketCodigo(maxCodeTicket);
            Parqueo parqueo = new Parqueo();
            parqueo.setParCodigo(maxCode);
            ticket.setParqueo(maxCode);
            ticket.setTicketFecha(new Date());
            ticket.setTicketEstado("A");

            parqueoRepository.save(parqueoDTO.toEntity());
            ResponseEntity response = ticketRestController.save(ticket);

            String nombreCliente = parqueoRepository.nombre(maxCode);
            TickectDTO tk = (TickectDTO) response.getBody();
            int ticketGenerado = tk.getTicketCodigo();
            String msj = "Hola! Señor(a) " + nombreCliente+ " Su ticket es: " +ticketGenerado + " con esto puede pagar su factura";
            HashMap<String, String> message = new HashMap<>();
            message.put("message", msj);
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
