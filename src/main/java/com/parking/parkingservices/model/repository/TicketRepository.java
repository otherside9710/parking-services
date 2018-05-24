package com.parking.parkingservices.model.repository;

import com.parking.parkingservices.model.entity.Ticket;
import com.parking.parkingservices.model.entity.Zonas;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TicketRepository extends PagingAndSortingRepository<Ticket, String> {
    List<Ticket> findAll();

    Ticket save(Ticket ticket);
}
