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
 * @author Otherside
 */
@Embeddable
public class ZonasPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "zona_codigo")
    private int zonaCodigo;
    @Basic(optional = false)
    @Column(name = "par_codigo")
    private int parCodigo;

    public ZonasPK() {
    }

    public ZonasPK(int zonaCodigo, int parCodigo) {
        this.zonaCodigo = zonaCodigo;
        this.parCodigo = parCodigo;
    }

    public int getZonaCodigo() {
        return zonaCodigo;
    }

    public void setZonaCodigo(int zonaCodigo) {
        this.zonaCodigo = zonaCodigo;
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
        hash += (int) zonaCodigo;
        hash += (int) parCodigo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZonasPK)) {
            return false;
        }
        ZonasPK other = (ZonasPK) object;
        if (this.zonaCodigo != other.zonaCodigo) {
            return false;
        }
        if (this.parCodigo != other.parCodigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpaentity.ZonasPK[ zonaCodigo=" + zonaCodigo + ", parCodigo=" + parCodigo + " ]";
    }
    
}
