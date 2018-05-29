/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.parkingservices.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author MyAsesor
 */
@Embeddable
public class TicketPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ticket_codigo")
    private int ticketCodigo;
    @Basic(optional = false)
    @Column(name = "par_codigo")
    private int parCodigo;

    public TicketPK() {
    }

    public TicketPK(int ticketCodigo, int parCodigo) {
        this.ticketCodigo = ticketCodigo;
        this.parCodigo = parCodigo;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) ticketCodigo;
        hash += (int) parCodigo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TicketPK)) {
            return false;
        }
        TicketPK other = (TicketPK) object;
        if (this.ticketCodigo != other.ticketCodigo) {
            return false;
        }
        if (this.parCodigo != other.parCodigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpaentity.TicketPK[ ticketCodigo=" + ticketCodigo + ", parCodigo=" + parCodigo + " ]";
    }
    
}
