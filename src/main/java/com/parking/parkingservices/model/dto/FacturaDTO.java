package com.parking.parkingservices.model.dto;

import com.parking.parkingservices.model.entity.Facturas;
import com.parking.parkingservices.model.entity.Ticket;
import com.parking.parkingservices.model.entity.TicketPK;

import java.util.Date;

public class FacturaDTO {
    private Integer factCodigo;
    private Date factFecha;
    private String factEstado;
    private String factDescripcion;
    private Integer ticketCodigo;
    private Integer parCodigo;

    public FacturaDTO(Integer factCodigo, Date factFecha, String factEstado,
                      String factDescripcion, Integer ticketCodigo, Integer parCodigo) {
        this.factCodigo = factCodigo;
        this.factFecha = factFecha;
        this.factEstado = factEstado;
        this.factDescripcion = factDescripcion;
        this.ticketCodigo = ticketCodigo;
        this.parCodigo = parCodigo;
    }

    public static FacturaDTO createFromEntity(Facturas facturas){
        return new FacturaDTO(
                facturas.getFactCodigo(),
                facturas.getFactFecha(),
                facturas.getFactEstado(),
                facturas.getFactDescripcion(),
                facturas.getTicketCodigo().getTicketPK().getTicketCodigo(),
                facturas.getTicketCodigo().getTicketPK().getParCodigo()
        );
    }

    public Facturas toEntity(){
        Facturas facturas = new Facturas();
        facturas.setFactCodigo(this.factCodigo);
        facturas.setFactFecha(this.factFecha);
        facturas.setFactEstado(this.factEstado);
        facturas.setFactDescripcion(this.factDescripcion);

        Ticket ticket = new Ticket();
        TicketPK ticketPK = new TicketPK();
        ticketPK.setTicketCodigo(this.ticketCodigo);
        ticketPK.setParCodigo(this.parCodigo);
        ticket.setTicketPK(ticketPK);

        facturas.setTicketCodigo(ticket);
        return facturas;
    }

    public Integer getFactCodigo() {
        return factCodigo;
    }

    public void setFactCodigo(Integer factCodigo) {
        this.factCodigo = factCodigo;
    }

    public Date getFactFecha() {
        return factFecha;
    }

    public void setFactFecha(Date factFecha) {
        this.factFecha = factFecha;
    }

    public String getFactEstado() {
        return factEstado;
    }

    public void setFactEstado(String factEstado) {
        this.factEstado = factEstado;
    }

    public String getFactDescripcion() {
        return factDescripcion;
    }

    public void setFactDescripcion(String factDescripcion) {
        this.factDescripcion = factDescripcion;
    }

    public Integer getTicketCodigo() {
        return ticketCodigo;
    }

    public void setTicketCodigo(Integer ticketCodigo) {
        this.ticketCodigo = ticketCodigo;
    }

    public Integer getParCodigo() {
        return parCodigo;
    }

    public void setParCodigo(Integer parCodigo) {
        this.parCodigo = parCodigo;
    }
}
