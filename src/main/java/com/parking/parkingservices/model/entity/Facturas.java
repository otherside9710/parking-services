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
@Table(name = "facturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturas.findAll", query = "SELECT f FROM Facturas f")
    , @NamedQuery(name = "Facturas.findByFactCodigo", query = "SELECT f FROM Facturas f WHERE f.factCodigo = :factCodigo")
    , @NamedQuery(name = "Facturas.findByFactEstado", query = "SELECT f FROM Facturas f WHERE f.factEstado = :factEstado")
    , @NamedQuery(name = "Facturas.findByFactDescripcion", query = "SELECT f FROM Facturas f WHERE f.factDescripcion = :factDescripcion")})
public class Facturas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fact_codigo")
    private Integer factCodigo;
    @Column(name = "fact_estado")
    private String factEstado;
    @Column(name = "fact_descripcion")
    private String factDescripcion;
    @JoinColumn(name = "usua_codigo", referencedColumnName = "usua_codigo")
    @ManyToOne
    private Usuarios usuaCodigo;
    @JoinColumn(name = "clie_codigo", referencedColumnName = "clie_codigo")
    @ManyToOne
    private Clientes clieCodigo;

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

    public Usuarios getUsuaCodigo() {
        return usuaCodigo;
    }

    public void setUsuaCodigo(Usuarios usuaCodigo) {
        this.usuaCodigo = usuaCodigo;
    }

    public Clientes getClieCodigo() {
        return clieCodigo;
    }

    public void setClieCodigo(Clientes clieCodigo) {
        this.clieCodigo = clieCodigo;
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
