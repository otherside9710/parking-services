/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.parkingservices.model.entity;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MyAsesor
 */
@Entity
@Table(name = "zonas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zonas.findAll", query = "SELECT z FROM Zonas z")
    , @NamedQuery(name = "Zonas.findByZonaCodigo", query = "SELECT z FROM Zonas z WHERE z.zonaCodigo = :zonaCodigo")
    , @NamedQuery(name = "Zonas.findByZonaDescripcion", query = "SELECT z FROM Zonas z WHERE z.zonaDescripcion = :zonaDescripcion")
    , @NamedQuery(name = "Zonas.findByZonaEstado", query = "SELECT z FROM Zonas z WHERE z.zonaEstado = :zonaEstado")})
public class Zonas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "zona_codigo")
    private Integer zonaCodigo;
    @Column(name = "zona_descripcion")
    private String zonaDescripcion;
    @Column(name = "zona_estado")
    private String zonaEstado;
    @JoinColumn(name = "par_codigo", referencedColumnName = "par_codigo")
    @ManyToOne(optional = false)
    private Parqueo parCodigo;
    @OneToMany(mappedBy = "zonaCodigo")
    private List<Parqueo> parqueoList;
    @OneToMany(mappedBy = "zonaCodigo")
    private List<Vehiculo> vehiculoList;

    public Zonas() {
    }

    public Zonas(Integer zonaCodigo) {
        this.zonaCodigo = zonaCodigo;
    }

    public Integer getZonaCodigo() {
        return zonaCodigo;
    }

    public void setZonaCodigo(Integer zonaCodigo) {
        this.zonaCodigo = zonaCodigo;
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

    public Parqueo getParCodigo() {
        return parCodigo;
    }

    public void setParCodigo(Parqueo parCodigo) {
        this.parCodigo = parCodigo;
    }

    @XmlTransient
    public List<Parqueo> getParqueoList() {
        return parqueoList;
    }

    public void setParqueoList(List<Parqueo> parqueoList) {
        this.parqueoList = parqueoList;
    }

    @XmlTransient
    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zonaCodigo != null ? zonaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zonas)) {
            return false;
        }
        Zonas other = (Zonas) object;
        if ((this.zonaCodigo == null && other.zonaCodigo != null) || (this.zonaCodigo != null && !this.zonaCodigo.equals(other.zonaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpaentity.Zonas[ zonaCodigo=" + zonaCodigo + " ]";
    }
    
}
