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
public class UsuariosPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "usua_codigo")
    private int usuaCodigo;
    @Basic(optional = false)
    @Column(name = "rol_codigo")
    private int rolCodigo;

    public UsuariosPK() {
    }

    public UsuariosPK(int usuaCodigo, int rolCodigo) {
        this.usuaCodigo = usuaCodigo;
        this.rolCodigo = rolCodigo;
    }

    public int getUsuaCodigo() {
        return usuaCodigo;
    }

    public void setUsuaCodigo(int usuaCodigo) {
        this.usuaCodigo = usuaCodigo;
    }

    public int getRolCodigo() {
        return rolCodigo;
    }

    public void setRolCodigo(int rolCodigo) {
        this.rolCodigo = rolCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usuaCodigo;
        hash += (int) rolCodigo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosPK)) {
            return false;
        }
        UsuariosPK other = (UsuariosPK) object;
        if (this.usuaCodigo != other.usuaCodigo) {
            return false;
        }
        if (this.rolCodigo != other.rolCodigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpaentity.UsuariosPK[ usuaCodigo=" + usuaCodigo + ", rolCodigo=" + rolCodigo + " ]";
    }
    
}
