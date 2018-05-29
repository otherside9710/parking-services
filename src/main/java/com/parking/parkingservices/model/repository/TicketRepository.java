package com.parking.parkingservices.model.repository;

import com.parking.parkingservices.model.entity.Ticket;
import com.parking.parkingservices.model.entity.TicketPK;
import com.parking.parkingservices.model.entity.Zonas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TicketRepository extends PagingAndSortingRepository<Ticket, TicketPK> {
    List<Ticket> findAll();

    Ticket save(Ticket ticket);

    @Query(value = "SELECT max (t.ticketPK.ticketCodigo) from Ticket t")
    String maxCode();

    @Query(value = "SELECT count(t.ticketPK.ticketCodigo) from Ticket t")
    String maxCount();
}
