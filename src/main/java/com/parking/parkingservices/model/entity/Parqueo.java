/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.parkingservices.model.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MyAsesor
 */
@Entity
@Table(name = "parqueo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parqueo.findAll", query = "SELECT p FROM Parqueo p")
    , @NamedQuery(name = "Parqueo.findByParCodigo", query = "SELECT p FROM Parqueo p WHERE p.parCodigo = :parCodigo")
    , @NamedQuery(name = "Parqueo.findByParHinicio", query = "SELECT p FROM Parqueo p WHERE p.parHinicio = :parHinicio")
    , @NamedQuery(name = "Parqueo.findByParHfinal", query = "SELECT p FROM Parqueo p WHERE p.parHfinal = :parHfinal")
    , @NamedQuery(name = "Parqueo.findByParEstado", query = "SELECT p FROM Parqueo p WHERE p.parEstado = :parEstado")
    , @NamedQuery(name = "Parqueo.findByParObservacion", query = "SELECT p FROM Parqueo p WHERE p.parObservacion = :parObservacion")})
public class Parqueo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "par_codigo")
    private Integer parCodigo;
    @Column(name = "par_hinicio")
    private String parHinicio;
    @Column(name = "par_hfinal")
    private String parHfinal;
    @Column(name = "par_estado")
    private String parEstado;
    @Column(name = "par_observacion")
    private String parObservacion;
    @JoinColumn(name = "usua_codigo", referencedColumnName = "usua_codigo")
    @ManyToOne
    private Usuarios usuaCodigo;
    @JoinColumn(name = "veh_codigo", referencedColumnName = "veh_codigo")
    @ManyToOne
    private Vehiculo vehCodigo;
    @JoinColumn(name = "zona_codigo", referencedColumnName = "zona_codigo")
    @ManyToOne
    private Zonas zonaCodigo;

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

    public String getParHinicio() {
        return parHinicio;
    }

    public void setParHinicio(String parHinicio) {
        this.parHinicio = parHinicio;
    }

    public String getParHfinal() {
        return parHfinal;
    }

    public void setParHfinal(String parHfinal) {
        this.parHfinal = parHfinal;
    }

    public String getParEstado() {
        return parEstado;
    }

    public void setParEstado(String parEstado) {
        this.parEstado = parEstado;
    }

    public String getParObservacion() {
        return parObservacion;
    }

    public void setParObservacion(String parObservacion) {
        this.parObservacion = parObservacion;
    }

    public Usuarios getUsuaCodigo() {
        return usuaCodigo;
    }

    public void setUsuaCodigo(Usuarios usuaCodigo) {
        this.usuaCodigo = usuaCodigo;
    }

    public Vehiculo getVehCodigo() {
        return vehCodigo;
    }

    public void setVehCodigo(Vehiculo vehCodigo) {
        this.vehCodigo = vehCodigo;
    }

    public Zonas getZonaCodigo() {
        return zonaCodigo;
    }

    public void setZonaCodigo(Zonas zonaCodigo) {
        this.zonaCodigo = zonaCodigo;
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
