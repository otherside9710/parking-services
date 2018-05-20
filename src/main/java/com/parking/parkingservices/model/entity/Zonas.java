/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.parkingservices.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Otherside
 */
@Entity
@Table(name = "zonas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zonas.findAll", query = "SELECT z FROM Zonas z")
    , @NamedQuery(name = "Zonas.findByZonaCodigo", query = "SELECT z FROM Zonas z WHERE z.zonasPK.zonaCodigo = :zonaCodigo")
    , @NamedQuery(name = "Zonas.findByZonaDescripcion", query = "SELECT z FROM Zonas z WHERE z.zonaDescripcion = :zonaDescripcion")
    , @NamedQuery(name = "Zonas.findByZonaEstado", query = "SELECT z FROM Zonas z WHERE z.zonaEstado = :zonaEstado")
    , @NamedQuery(name = "Zonas.findByParCodigo", query = "SELECT z FROM Zonas z WHERE z.zonasPK.parCodigo = :parCodigo")})
public class Zonas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ZonasPK zonasPK;
    @Column(name = "zona_descripcion")
    private String zonaDescripcion;
    @Column(name = "zona_estado")
    private String zonaEstado;
    @JoinColumn(name = "par_codigo", referencedColumnName = "par_codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Parqueo parqueo;

    public Zonas() {
    }

    public Zonas(ZonasPK zonasPK) {
        this.zonasPK = zonasPK;
    }

    public Zonas(int zonaCodigo, int parCodigo) {
        this.zonasPK = new ZonasPK(zonaCodigo, parCodigo);
    }

    public ZonasPK getZonasPK() {
        return zonasPK;
    }

    public void setZonasPK(ZonasPK zonasPK) {
        this.zonasPK = zonasPK;
    }

    public String getZonaDescripcion() {
        return zonaDescripcion;
    }

    public void setZonaDescripcion(String zonaDescripcion) {
        this.zonaDescripcion = zonaDescripcion;
    }

    public String getZonaEstado() {
        return zonaEstado;
    }

    public void setZonaEstado(String zonaEstado) {
        this.zonaEstado = zonaEstado;
    }

    public Parqueo getParqueo() {
        return parqueo;
    }

    public void setParqueo(Parqueo parqueo) {
        this.parqueo = parqueo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zonasPK != null ? zonasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zonas)) {
            return false;
        }
        Zonas other = (Zonas) object;
        if ((this.zonasPK == null && other.zonasPK != null) || (this.zonasPK != null && !this.zonasPK.equals(other.zonasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpaentity.Zonas[ zonasPK=" + zonasPK + " ]";
    }
    
}
