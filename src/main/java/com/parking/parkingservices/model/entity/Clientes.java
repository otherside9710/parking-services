/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.parkingservices.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MyAsesor
 */
@Entity
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c")
    , @NamedQuery(name = "Clientes.findByClieCodigo", query = "SELECT c FROM Clientes c WHERE c.clieCodigo = :clieCodigo")
    , @NamedQuery(name = "Clientes.findByClieNombres", query = "SELECT c FROM Clientes c WHERE c.clieNombres = :clieNombres")
    , @NamedQuery(name = "Clientes.findByClieApellidos", query = "SELECT c FROM Clientes c WHERE c.clieApellidos = :clieApellidos")
    , @NamedQuery(name = "Clientes.findByClieCedula", query = "SELECT c FROM Clientes c WHERE c.clieCedula = :clieCedula")
    , @NamedQuery(name = "Clientes.findByClieTelefono", query = "SELECT c FROM Clientes c WHERE c.clieTelefono = :clieTelefono")
    , @NamedQuery(name = "Clientes.findByClieCiudad", query = "SELECT c FROM Clientes c WHERE c.clieCiudad = :clieCiudad")
    , @NamedQuery(name = "Clientes.findByClieDireccion", query = "SELECT c FROM Clientes c WHERE c.clieDireccion = :clieDireccion")
    , @NamedQuery(name = "Clientes.findByClieEmail", query = "SELECT c FROM Clientes c WHERE c.clieEmail = :clieEmail")
    , @NamedQuery(name = "Clientes.findByClieEstado", query = "SELECT c FROM Clientes c WHERE c.clieEstado = :clieEstado")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "clie_codigo")
    private Integer clieCodigo;
    @Column(name = "clie_nombres")
    private String clieNombres;
    @Column(name = "clie_apellidos")
    private String clieApellidos;
    @Basic(optional = false)
    @Column(name = "clie_cedula")
    private String clieCedula;
    @Column(name = "clie_telefono")
    private String clieTelefono;
    @Column(name = "clie_ciudad")
    private String clieCiudad;
    @Column(name = "clie_direccion")
    private String clieDireccion;
    @Column(name = "clie_email")
    private String clieEmail;
    @Column(name = "clie_estado")
    private String clieEstado;
    @JoinColumn(name = "fact_codigo", referencedColumnName = "fact_codigo")
    @ManyToOne(optional = false)
    private Facturas factCodigo;
    @JoinColumn(name = "ticket_codigo", referencedColumnName = "ticket_codigo")
    @ManyToOne(optional = false)
    private Ticket ticketCodigo;
    @JoinColumn(name = "veh_codigo", referencedColumnName = "veh_codigo")
    @ManyToOne(optional = false)
    private Vehiculo vehCodigo;

    public Clientes() {
    }

    public Clientes(Integer clieCodigo) {
        this.clieCodigo = clieCodigo;
    }

    public Clientes(Integer clieCodigo, String clieCedula) {
        this.clieCodigo = clieCodigo;
        this.clieCedula = clieCedula;
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

    public Facturas getFactCodigo() {
        return factCodigo;
    }

    public void setFactCodigo(Facturas factCodigo) {
        this.factCodigo = factCodigo;
    }

    public Ticket getTicketCodigo() {
        return ticketCodigo;
    }

    public void setTicketCodigo(Ticket ticketCodigo) {
        this.ticketCodigo = ticketCodigo;
    }

    public Vehiculo getVehCodigo() {
        return vehCodigo;
    }

    public void setVehCodigo(Vehiculo vehCodigo) {
        this.vehCodigo = vehCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clieCodigo != null ? clieCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.clieCodigo == null && other.clieCodigo != null) || (this.clieCodigo != null && !this.clieCodigo.equals(other.clieCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpaentity.Clientes[ clieCodigo=" + clieCodigo + " ]";
    }
    
}
