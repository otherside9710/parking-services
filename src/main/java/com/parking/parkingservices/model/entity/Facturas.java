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
 * @author Otherside
 */
@Entity
@Table(name = "facturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturas.findAll", query = "SELECT f FROM Facturas f")
    , @NamedQuery(name = "Facturas.findByFactCodigo", query = "SELECT f FROM Facturas f WHERE f.factCodigo = :factCodigo")
    , @NamedQuery(name = "Facturas.findByFactFecha", query = "SELECT f FROM Facturas f WHERE f.factFecha = :factFecha")
    , @NamedQuery(name = "Facturas.findByFactEstado", query = "SELECT f FROM Facturas f WHERE f.factEstado = :factEstado")
    , @NamedQuery(name = "Facturas.findByFactDescripcion", query = "SELECT f FROM Facturas f WHERE f.factDescripcion = :factDescripcion")})
public class Facturas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fact_codigo")
    private Integer factCodigo;
    @Column(name = "fact_fecha")
    @Temporal(TemporalType.DATE)
    private Date factFecha;
    @Column(name = "fact_estado")
    private String factEstado;
    @Column(name = "fact_descripcion")
    private String factDescripcion;
    @JoinColumn(name = "ticket_codigo", referencedColumnName = "ticket_codigo")
    @ManyToOne
    private Ticket ticketCodigo;

    public Facturas() {
    }

    public Facturas(Integer factCodigo) {
        this.factCodigo = factCodigo;
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

    public Ticket getTicketCodigo() {
        return ticketCodigo;
    }

    public void setTicketCodigo(Ticket ticketCodigo) {
        this.ticketCodigo = ticketCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (factCodigo != null ? factCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturas)) {
            return false;
        }
        Facturas other = (Facturas) object;
        if ((this.factCodigo == null && other.factCodigo != null) || (this.factCodigo != null && !this.factCodigo.equals(other.factCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpaentity.Facturas[ factCodigo=" + factCodigo + " ]";
    }
    
}
