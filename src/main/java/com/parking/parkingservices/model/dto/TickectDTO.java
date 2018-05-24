package com.parking.parkingservices.model.dto;

import com.parking.parkingservices.model.entity.Ticket;

import java.util.Date;

public class TickectDTO {
    private Integer ticketCodigo;
    private Date ticketFecha;
    private String ticketEstado;

    public TickectDTO() {
    }

    public TickectDTO(Integer ticketCodigo, Date ticketFecha, String ticketEstado) {
        this.ticketCodigo = ticketCodigo;
        this.ticketFecha = ticketFecha;
        this.ticketEstado = ticketEstado;
    }

    public static TickectDTO createFromEntity(Ticket ticket){
        return new TickectDTO(
                ticket.getTicketCodigo(),
                ticket.getTicketFecha(),
                ticket.getTicketEstado()
        );
    }

    public Ticket toEntity(){
        Ticket ticket = new Ticket();
        ticket.setTicketCodigo(this.ticketCodigo);
        ticket.setTicketFecha(this.ticketFecha);
        ticket.setTicketEstado(this.ticketEstado);
        return ticket;
    }

    public Integer getTicketCodigo() {
        return ticketCodigo;
    }

    public void setTicketCodigo(Integer ticketCodigo) {
        this.ticketCodigo = ticketCodigo;
    }

    public Date getTicketFecha() {
        return ticketFecha;
    }

    public void setTicketFecha(Date ticketFecha) {
        this.ticketFecha = ticketFecha;
    }

    public String getTicketEstado() {
        return ticketEstado;
    }

    public void setTicketEstado(String ticketEstado) {
        this.ticketEstado = ticketEstado;
    }
}
