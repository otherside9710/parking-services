/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.parkingservices.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MyAsesor
 */
@Entity
@Table(name = "ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t")
    , @NamedQuery(name = "Ticket.findByTicketCodigo", query = "SELECT t FROM Ticket t WHERE t.ticketPK.ticketCodigo = :ticketCodigo")
    , @NamedQuery(name = "Ticket.findByParCodigo", query = "SELECT t FROM Ticket t WHERE t.ticketPK.parCodigo = :parCodigo")
    , @NamedQuery(name = "Ticket.findByTicketFecha", query = "SELECT t FROM Ticket t WHERE t.ticketFecha = :ticketFecha")
    , @NamedQuery(name = "Ticket.findByTicketEstado", query = "SELECT t FROM Ticket t WHERE t.ticketEstado = :ticketEstado")})
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TicketPK ticketPK;
    @Basic(optional = false)
    @Column(name = "ticket_fecha")
    @Temporal(TemporalType.DATE)
    private Date ticketFecha;
    @Column(name = "ticket_estado")
    private String ticketEstado;
    @JoinColumn(name = "par_codigo", referencedColumnName = "par_codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Parqueo parqueo;
    @OneToMany(mappedBy = "ticketCodigo")
    private List<Facturas> facturasList;

    public Ticket() {
    }

    public Ticket(TicketPK ticketPK) {
        this.ticketPK = ticketPK;
    }

    public Ticket(TicketPK ticketPK, Date ticketFecha) {
        this.ticketPK = ticketPK;
        this.ticketFecha = ticketFecha;
    }

    public Ticket(int ticketCodigo, int parCodigo) {
        this.ticketPK = new TicketPK(ticketCodigo, parCodigo);
    }

    public TicketPK getTicketPK() {
        return ticketPK;
    }

    public void setTicketPK(TicketPK ticketPK) {
        this.ticketPK = ticketPK;
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

    public Parqueo getParqueo() {
        return parqueo;
    }

    public void setParqueo(Parqueo parqueo) {
        this.parqueo = parqueo;
    }

    @XmlTransient
    public List<Facturas> getFacturasList() {
        return facturasList;
    }

    public void setFacturasList(List<Facturas> facturasList) {
        this.facturasList = facturasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketPK != null ? ticketPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.ticketPK == null && other.ticketPK != null) || (this.ticketPK != null && !this.ticketPK.equals(other.ticketPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpaentity.Ticket[ ticketPK=" + ticketPK + " ]";
    }
    
}
