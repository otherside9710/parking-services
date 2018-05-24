package com.parking.parkingservices.model.dto;

import com.parking.parkingservices.model.entity.Facturas;
import com.parking.parkingservices.model.entity.Roles;
import com.parking.parkingservices.model.entity.Ticket;
import com.parking.parkingservices.model.entity.Usuarios;

public class UsuariosDTO {
    private Integer usuaCodigo;
    private String usuaNombres;
    private String usuaApellidos;
    private String usuaCedula;
    private String usuaEstado;
    private Integer factCodigo;
    private Integer rolCodigo;
    private Integer ticketCodigo;

    public UsuariosDTO() {
    }

    public UsuariosDTO(Integer usuaCodigo, String usuaNombres,
                       String usuaApellidos, String usuaCedula,
                       String usuaEstado, Integer factCodigo,
                       Integer rolCodigo, Integer ticketCodigo) {
        this.usuaCodigo = usuaCodigo;
        this.usuaNombres = usuaNombres;
        this.usuaApellidos = usuaApellidos;
        this.usuaCedula = usuaCedula;
        this.usuaEstado = usuaEstado;
        this.factCodigo = factCodigo;
        this.rolCodigo = rolCodigo;
        this.ticketCodigo = ticketCodigo;
    }

    public static UsuariosDTO createFromEntity(Usuarios usuarios){
        return new UsuariosDTO(
                usuarios.getUsuaCodigo(),
                usuarios.getUsuaNombres(),
                usuarios.getUsuaApellidos(),
                usuarios.getUsuaCedula(),
                usuarios.getUsuaEstado(),
                usuarios.getFactCodigo().getFactCodigo(),
                usuarios.getRolCodigo().getRolCodigo(),
                usuarios.getTicketCodigo().getTicketCodigo()
        );
    }

    public Usuarios toEntity(){
        Usuarios usuarios = new Usuarios();

        usuarios.setUsuaCodigo(this.usuaCodigo);
        usuarios.setUsuaNombres(this.usuaNombres);
        usuarios.setUsuaApellidos(this.usuaApellidos);
        usuarios.setUsuaCedula(this.usuaCedula);
        usuarios.setUsuaEstado(this.usuaEstado);

        Facturas facturas = new Facturas();
        facturas.setFactCodigo(this.factCodigo);

        Roles roles = new Roles();
        roles.setRolCodigo(this.rolCodigo);

        Ticket ticket = new Ticket();
        ticket.setTicketCodigo(this.ticketCodigo);

        usuarios.setFactCodigo(facturas);
        usuarios.setRolCodigo(roles);
        usuarios.setTicketCodigo(ticket);

        return usuarios;
    }

    public Integer getUsuaCodigo() {
        return usuaCodigo;
    }

    public void setUsuaCodigo(Integer usuaCodigo) {
        this.usuaCodigo = usuaCodigo;
    }

    public String getUsuaNombres() {
        return usuaNombres;
    }

    public void setUsuaNombres(String usuaNombres) {
        this.usuaNombres = usuaNombres;
    }

    public String getUsuaApellidos() {
        return usuaApellidos;
    }

    public void setUsuaApellidos(String usuaApellidos) {
        this.usuaApellidos = usuaApellidos;
    }

    public String getUsuaCedula() {
        return usuaCedula;
    }

    public void setUsuaCedula(String usuaCedula) {
        this.usuaCedula = usuaCedula;
    }

    public String getUsuaEstado() {
        return usuaEstado;
    }

    public void setUsuaEstado(String usuaEstado) {
        this.usuaEstado = usuaEstado;
    }

    public Integer getFactCodigo() {
        return factCodigo;
    }

    public void setFactCodigo(Integer factCodigo) {
        this.factCodigo = factCodigo;
    }

    public Integer getRolCodigo() {
        return rolCodigo;
    }

    public void setRolCodigo(Integer rolCodigo) {
        this.rolCodigo = rolCodigo;
    }

    public Integer getTicketCodigo() {
        return ticketCodigo;
    }

    public void setTicketCodigo(Integer ticketCodigo) {
        this.ticketCodigo = ticketCodigo;
    }
}
