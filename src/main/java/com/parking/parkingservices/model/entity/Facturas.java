/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.parkingservices.model.entity;

import java.io.Serializable;
import java.util.List;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factCodigo")
    private List<Clientes> clientesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factCodigo")
    private List<Usuarios> usuariosList;

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

    @XmlTransient
    public List<Clientes> getClientesList() {
        return clientesList;
    }

    public void setClientesList(List<Clientes> clientesList) {
        this.clientesList = clientesList;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
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
