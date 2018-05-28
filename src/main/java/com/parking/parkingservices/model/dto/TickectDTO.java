package com.parking.parkingservices.model.dto;

import com.parking.parkingservices.model.entity.*;

import java.util.Date;

public class TickectDTO {
    private int ticketCodigo;
    private int parCodigo;
    private Date ticketFecha;
    private String ticketEstado;
    private int parqueo;

    public TickectDTO() {
    }

    public TickectDTO(int ticketCodigo, int parCodigo,
                      Date ticketFecha, String ticketEstado, int parqueo) {
        this.ticketCodigo = ticketCodigo;
        this.parCodigo = parCodigo;
        this.ticketFecha = ticketFecha;
        this.ticketEstado = ticketEstado;
        this.parqueo = parqueo;
    }

    public static TickectDTO createFromEntity(Ticket ticket){
        return new TickectDTO(
                ticket.getTicketPK().getTicketCodigo(),
                ticket.getTicketPK().getParCodigo(),
                ticket.getTicketFecha(),
                ticket.getTicketEstado(),
                ticket.getParqueo().getParCodigo()
        );
    }

    public Ticket toEntity(){
        Ticket ticket = new Ticket();
        TicketPK ticketPK = new TicketPK();

        ticketPK.setParCodigo(this.parCodigo);
        ticketPK.setTicketCodigo(this.ticketCodigo);
        ticket.setTicketPK(ticketPK);

        ticket.setTicketFecha(this.ticketFecha);
        ticket.setTicketEstado(this.ticketEstado);

        Parqueo parqueo = new Parqueo();
        parqueo.setParCodigo(this.parCodigo);
        ticket.setParqueo(parqueo);

        return ticket;
    }

    public int getTicketCodigo() {
        return ticketCodigo;
    }

    public void setTicketCodigo(int ticketCodigo) {
        this.ticketCodigo = ticketCodigo;
    }

    public int getParCodigo() {
        return parCodigo;
    }

    public void setParCodigo(int parCodigo) {
        this.parCodigo = parCodigo;
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

    public int getParqueo() {
        return parqueo;
    }

    public void setParqueo(int parqueo) {
        this.parqueo = parqueo;
    }
}
