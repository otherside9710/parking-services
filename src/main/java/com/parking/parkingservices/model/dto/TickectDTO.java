package com.parking.parkingservices.model.dto;

import com.parking.parkingservices.model.entity.Clientes;
import com.parking.parkingservices.model.entity.Ticket;
import com.parking.parkingservices.model.entity.Usuarios;

import java.util.Date;

public class TickectDTO {
    private Integer ticketCodigo;
    private Date ticketFecha;
    private String ticketEstado;
    private Integer clieCodigo;
    private Integer usuaCodigo;

    public TickectDTO() {
    }

    public TickectDTO(Integer ticketCodigo, Date ticketFecha,
                      String ticketEstado, Integer clieCodigo, Integer usuaCodigo) {
        this.ticketCodigo = ticketCodigo;
        this.ticketFecha = ticketFecha;
        this.ticketEstado = ticketEstado;
        this.clieCodigo = clieCodigo;
        this.usuaCodigo = usuaCodigo;
    }

    public static TickectDTO createFromEntity(Ticket ticket){
        return new TickectDTO(
                ticket.getTicketCodigo(),
                ticket.getTicketFecha(),
                ticket.getTicketEstado(),
                ticket.getClieCodigo().getClieCodigo(),
                ticket.getUsuaCodigo().getUsuaCodigo()
        );
    }

    public Ticket toEntity(){
        Ticket ticket = new Ticket();
        ticket.setTicketCodigo(this.ticketCodigo);
        ticket.setTicketFecha(this.ticketFecha);
        ticket.setTicketEstado(this.ticketEstado);

        Clientes clientes = new Clientes();
        clientes.setClieCodigo(this.clieCodigo);

        Usuarios usuarios = new Usuarios();
        usuarios.setUsuaCodigo(this.usuaCodigo);

        ticket.setClieCodigo(clientes);
        ticket.setUsuaCodigo(usuarios);
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

    public Integer getClieCodigo() {
        return clieCodigo;
    }

    public void setClieCodigo(Integer clieCodigo) {
        this.clieCodigo = clieCodigo;
    }

    public Integer getUsuaCodigo() {
        return usuaCodigo;
    }

    public void setUsuaCodigo(Integer usuaCodigo) {
        this.usuaCodigo = usuaCodigo;
    }
}
