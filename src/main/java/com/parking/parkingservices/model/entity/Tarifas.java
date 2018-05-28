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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Otherside
 */
@Entity
@Table(name = "tarifas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarifas.findAll", query = "SELECT t FROM Tarifas t")
    , @NamedQuery(name = "Tarifas.findByTariCodigo", query = "SELECT t FROM Tarifas t WHERE t.tariCodigo = :tariCodigo")
    , @NamedQuery(name = "Tarifas.findByTariDecripcion", query = "SELECT t FROM Tarifas t WHERE t.tariDecripcion = :tariDecripcion")
    , @NamedQuery(name = "Tarifas.findByTariValor", query = "SELECT t FROM Tarifas t WHERE t.tariValor = :tariValor")})
public class Tarifas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tari_codigo")
    private Integer tariCodigo;
    @Column(name = "tari_decripcion")
    private String tariDecripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tari_valor")
    private Double tariValor;

    public Tarifas() {
    }

    public Tarifas(Integer tariCodigo) {
        this.tariCodigo = tariCodigo;
    }

    public Integer getTariCodigo() {
        return tariCodigo;
    }

    public void setTariCodigo(Integer tariCodigo) {
        this.tariCodigo = tariCodigo;
    }

    public String getTariDecripcion() {
        return tariDecripcion;
    }

    public void setTariDecripcion(String tariDecripcion) {
        this.tariDecripcion = tariDecripcion;
    }

    public Double getTariValor() {
        return tariValor;
    }

    public void setTariValor(Double tariValor) {
        this.tariValor = tariValor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tariCodigo != null ? tariCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarifas)) {
            return false;
        }
        Tarifas other = (Tarifas) object;
        if ((this.tariCodigo == null && other.tariCodigo != null) || (this.tariCodigo != null && !this.tariCodigo.equals(other.tariCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpaentity.Tarifas[ tariCodigo=" + tariCodigo + " ]";
    }
    
}
