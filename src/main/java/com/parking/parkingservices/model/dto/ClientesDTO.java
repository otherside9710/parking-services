package com.parking.parkingservices.model.dto;

import com.parking.parkingservices.model.entity.Clientes;
import com.parking.parkingservices.model.entity.Facturas;
import com.parking.parkingservices.model.entity.Ticket;
import com.parking.parkingservices.model.entity.Vehiculo;

public class ClientesDTO {
    private Integer clieCodigo;
    private String clieNombres;
    private String clieApellidos;
    private String clieCedula;
    private String clieTelefono;
    private String clieCiudad;
    private String clieDireccion;
    private String clieEmail;
    private String clieEstado;
    private Integer factCodigo;
    private Integer ticketCodigo;
    private Integer vehCodigo;

    public ClientesDTO() {
    }

    public ClientesDTO(Integer clieCodigo, String clieNombres, String clieApellidos,
                       String clieCedula, String clieTelefono, String clieCiudad, String clieDireccion,
                       String clieEmail, String clieEstado, Integer factCodigo,
                       Integer ticketCodigo, Integer vehCodigo) {
        this.clieCodigo = clieCodigo;
        this.clieNombres = clieNombres;
        this.clieApellidos = clieApellidos;
        this.clieCedula = clieCedula;
        this.clieTelefono = clieTelefono;
        this.clieCiudad = clieCiudad;
        this.clieDireccion = clieDireccion;
        this.clieEmail = clieEmail;
        this.clieEstado = clieEstado;
        this.factCodigo = factCodigo;
        this.ticketCodigo = ticketCodigo;
        this.vehCodigo = vehCodigo;
    }

    public static ClientesDTO createFromEntity(Clientes clientes){
        return new ClientesDTO(
                clientes.getClieCodigo(),
                clientes.getClieNombres(),
                clientes.getClieApellidos(),
                clientes.getClieCedula(),
                clientes.getClieTelefono(),
                clientes.getClieCiudad(),
                clientes.getClieDireccion(),
                clientes.getClieEmail(),
                clientes.getClieEstado(),
                clientes.getFactCodigo().getFactCodigo(),
                clientes.getTicketCodigo().getTicketCodigo(),
                clientes.getVehCodigo().getVehCodigo()
        );
    }

    public Clientes toEntity(){
        Clientes clientes = new Clientes();
        clientes.setClieCodigo(this.clieCodigo);
        clientes.setClieNombres(this.clieNombres);
        clientes.setClieApellidos(this.clieApellidos);
        clientes.setClieCedula(this.clieCedula);
        clientes.setClieTelefono(this.clieTelefono);
        clientes.setClieCiudad(this.clieCiudad);
        clientes.setClieDireccion(this.clieDireccion);
        clientes.setClieEmail(this.clieEmail);
        clientes.setClieEstado(this.clieEstado);

        Facturas facturas = new Facturas();
        facturas.setFactCodigo(this.factCodigo);

        Ticket ticket = new Ticket();
        ticket.setTicketCodigo(this.ticketCodigo);

        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setVehCodigo(this.vehCodigo);

        clientes.setFactCodigo(facturas);
        clientes.setTicketCodigo(ticket);
        clientes.setVehCodigo(vehiculo);

        return clientes;
    }

    public Integer getClieCodigo() {
        return clieCodigo;
    }

    public void setClieCodigo(Integer clieCodigo) {
        this.clieCodigo = clieCodigo;
    }

    public String getClieNombres() {
        return clieNombres;
    }

    public void setClieNombres(String clieNombres) {
        this.clieNombres = clieNombres;
    }

    public String getClieApellidos() {
        return clieApellidos;
    }

    public void setClieApellidos(String clieApellidos) {
        this.clieApellidos = clieApellidos;
    }

    public String getClieCedula() {
        return clieCedula;
    }

    public void setClieCedula(String clieCedula) {
        this.clieCedula = clieCedula;
    }

    public String getClieTelefono() {
        return clieTelefono;
    }

    public void setClieTelefono(String clieTelefono) {
        this.clieTelefono = clieTelefono;
    }

    public String getClieCiudad() {
        return clieCiudad;
    }

    public void setClieCiudad(String clieCiudad) {
        this.clieCiudad = clieCiudad;
    }

    public String getClieDireccion() {
        return clieDireccion;
    }

    public void setClieDireccion(String clieDireccion) {
        this.clieDireccion = clieDireccion;
    }

    public String getClieEmail() {
        return clieEmail;
    }

    public void setClieEmail(String clieEmail) {
        this.clieEmail = clieEmail;
    }

    public String getClieEstado() {
        return clieEstado;
    }

    public void setClieEstado(String clieEstado) {
        this.clieEstado = clieEstado;
    }
}


