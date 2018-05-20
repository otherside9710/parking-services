/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.parkingservices.model.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Otherside
 */
@Entity
@Table(name = "tp_vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TpVehiculo.findAll", query = "SELECT t FROM TpVehiculo t")
    , @NamedQuery(name = "TpVehiculo.findByTpvCodigo", query = "SELECT t FROM TpVehiculo t WHERE t.tpvCodigo = :tpvCodigo")
    , @NamedQuery(name = "TpVehiculo.findByTpvDescripcion", query = "SELECT t FROM TpVehiculo t WHERE t.tpvDescripcion = :tpvDescripcion")})
public class TpVehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tpv_codigo")
    private Integer tpvCodigo;
    @Basic(optional = false)
    @Column(name = "tpv_descripcion")
    private String tpvDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tpvCodigo")
    private Collection<Vehiculo> vehiculoCollection;

    public TpVehiculo() {
    }

    public TpVehiculo(Integer tpvCodigo) {
        this.tpvCodigo = tpvCodigo;
    }

    public TpVehiculo(Integer tpvCodigo, String tpvDescripcion) {
        this.tpvCodigo = tpvCodigo;
        this.tpvDescripcion = tpvDescripcion;
    }

    public Integer getTpvCodigo() {
        return tpvCodigo;
    }

    public void setTpvCodigo(Integer tpvCodigo) {
        this.tpvCodigo = tpvCodigo;
    }

    public String getTpvDescripcion() {
        return tpvDescripcion;
    }

    public void setTpvDescripcion(String tpvDescripcion) {
        this.tpvDescripcion = tpvDescripcion;
    }

    @XmlTransient
    public Collection<Vehiculo> getVehiculoCollection() {
        return vehiculoCollection;
    }

    public void setVehiculoCollection(Collection<Vehiculo> vehiculoCollection) {
        this.vehiculoCollection = vehiculoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tpvCodigo != null ? tpvCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TpVehiculo)) {
            return false;
        }
        TpVehiculo other = (TpVehiculo) object;
        if ((this.tpvCodigo == null && other.tpvCodigo != null) || (this.tpvCodigo != null && !this.tpvCodigo.equals(other.tpvCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpaentity.TpVehiculo[ tpvCodigo=" + tpvCodigo + " ]";
    }
    
}
