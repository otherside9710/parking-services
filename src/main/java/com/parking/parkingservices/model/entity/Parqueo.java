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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "parqueo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parqueo.findAll", query = "SELECT p FROM Parqueo p")
    , @NamedQuery(name = "Parqueo.findByParCodigo", query = "SELECT p FROM Parqueo p WHERE p.parCodigo = :parCodigo")
    , @NamedQuery(name = "Parqueo.findByParDuracion", query = "SELECT p FROM Parqueo p WHERE p.parDuracion = :parDuracion")})
public class Parqueo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "par_codigo")
    private Integer parCodigo;
    @Column(name = "par_duracion")
    private Integer parDuracion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parqueo")
    private Collection<Zonas> zonasCollection;
    @JoinColumn(name = "tari_codigo", referencedColumnName = "tari_codigo")
    @ManyToOne(optional = false)
    private Tarifas tariCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parCodigo")
    private Collection<Vehiculo> vehiculoCollection;

    public Parqueo() {
    }

    public Parqueo(Integer parCodigo) {
        this.parCodigo = parCodigo;
    }

    public Integer getParCodigo() {
        return parCodigo;
    }

    public void setParCodigo(Integer parCodigo) {
        this.parCodigo = parCodigo;
    }

    public Integer getParDuracion() {
        return parDuracion;
    }

    public void setParDuracion(Integer parDuracion) {
        this.parDuracion = parDuracion;
    }

    @XmlTransient
    public Collection<Zonas> getZonasCollection() {
        return zonasCollection;
    }

    public void setZonasCollection(Collection<Zonas> zonasCollection) {
        this.zonasCollection = zonasCollection;
    }

    public Tarifas getTariCodigo() {
        return tariCodigo;
    }

    public void setTariCodigo(Tarifas tariCodigo) {
        this.tariCodigo = tariCodigo;
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
        hash += (parCodigo != null ? parCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parqueo)) {
            return false;
        }
        Parqueo other = (Parqueo) object;
        if ((this.parCodigo == null && other.parCodigo != null) || (this.parCodigo != null && !this.parCodigo.equals(other.parCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpaentity.Parqueo[ parCodigo=" + parCodigo + " ]";
    }
    
}
