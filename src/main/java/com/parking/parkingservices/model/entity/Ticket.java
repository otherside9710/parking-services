/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.parkingservices.model.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MyAsesor
 */
@Entity
@Table(name = "ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t")
    , @NamedQuery(name = "Ticket.findByTicketCodigo", query = "SELECT t FROM Ticket t WHERE t.ticketCodigo = :ticketCodigo")
    , @NamedQuery(name = "Ticket.findByTicketFecha", query = "SELECT t FROM Ticket t WHERE t.ticketFecha = :ticketFecha")
    , @NamedQuery(name = "Ticket.findByTicketEstado", query = "SELECT t FROM Ticket t WHERE t.ticketEstado = :ticketEstado")})
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ticket_codigo")
    private Integer ticketCodigo;
    @Basic(optional = false)
    @Column(name = "ticket_fecha")
    @Temporal(TemporalType.DATE)
    private Date ticketFecha;
    @Column(name = "ticket_estado")
    private String ticketEstado;
    @JoinColumn(name = "clie_codigo", referencedColumnName = "clie_codigo")
    @ManyToOne
    private Clientes clieCodigo;
    @JoinColumn(name = "usua_codigo", referencedColumnName = "usua_codigo")
    @ManyToOne
    private Usuarios usuaCodigo;

    public Ticket() {
    }

    public Ticket(Integer ticketCodigo) {
        this.ticketCodigo = ticketCodigo;
    }

    public Ticket(Integer ticketCodigo, Date ticketFecha) {
        this.ticketCodigo = ticketCodigo;
        this.ticketFecha = ticketFecha;
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

    public Clientes getClieCodigo() {
        return clieCodigo;
    }

    public void setClieCodigo(Clientes clieCodigo) {
        this.clieCodigo = clieCodigo;
    }

    public Usuarios getUsuaCodigo() {
        return usuaCodigo;
    }

    public void setUsuaCodigo(Usuarios usuaCodigo) {
        this.usuaCodigo = usuaCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketCodigo != null ? ticketCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.ticketCodigo == null && other.ticketCodigo != null) || (this.ticketCodigo != null && !this.ticketCodigo.equals(other.ticketCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpaentity.Ticket[ ticketCodigo=" + ticketCodigo + " ]";
    }
    
}
