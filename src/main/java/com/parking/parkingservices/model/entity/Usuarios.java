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
 * @author Otherside
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findByUsuaCodigo", query = "SELECT u FROM Usuarios u WHERE u.usuaCodigo = :usuaCodigo")
    , @NamedQuery(name = "Usuarios.findByUsuaPassword", query = "SELECT u FROM Usuarios u WHERE u.usuaPassword = :usuaPassword")
    , @NamedQuery(name = "Usuarios.findByUsuaNombres", query = "SELECT u FROM Usuarios u WHERE u.usuaNombres = :usuaNombres")
    , @NamedQuery(name = "Usuarios.findByUsuaApellidos", query = "SELECT u FROM Usuarios u WHERE u.usuaApellidos = :usuaApellidos")
    , @NamedQuery(name = "Usuarios.findByUsuaCedula", query = "SELECT u FROM Usuarios u WHERE u.usuaCedula = :usuaCedula")
    , @NamedQuery(name = "Usuarios.findByUsuaCiudad", query = "SELECT u FROM Usuarios u WHERE u.usuaCiudad = :usuaCiudad")
    , @NamedQuery(name = "Usuarios.findByUsuaEstado", query = "SELECT u FROM Usuarios u WHERE u.usuaEstado = :usuaEstado")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usua_codigo")
    private Integer usuaCodigo;
    @Basic(optional = false)
    @Column(name = "usua_password")
    private String usuaPassword;
    @Column(name = "usua_nombres")
    private String usuaNombres;
    @Column(name = "usua_apellidos")
    private String usuaApellidos;
    @Basic(optional = false)
    @Column(name = "usua_cedula")
    private String usuaCedula;
    @Column(name = "usua_ciudad")
    private String usuaCiudad;
    @Column(name = "usua_estado")
    private String usuaEstado;
    @OneToMany(mappedBy = "usuaCodigo")
    private List<Parqueo> parqueoList;
    @OneToMany(mappedBy = "usuaCodigo")
    private List<Facturas> facturasList;
    @JoinColumn(name = "rol_codigo", referencedColumnName = "rol_codigo")
    @ManyToOne(optional = false)
    private Roles rolCodigo;

    public Usuarios() {
    }

    public Usuarios(Integer usuaCodigo) {
        this.usuaCodigo = usuaCodigo;
    }

    public Usuarios(Integer usuaCodigo, String usuaPassword, String usuaCedula) {
        this.usuaCodigo = usuaCodigo;
        this.usuaPassword = usuaPassword;
        this.usuaCedula = usuaCedula;
    }

    public Integer getUsuaCodigo() {
        return usuaCodigo;
    }

    public void setUsuaCodigo(Integer usuaCodigo) {
        this.usuaCodigo = usuaCodigo;
    }

    public String getUsuaPassword() {
        return usuaPassword;
    }

    public void setUsuaPassword(String usuaPassword) {
        this.usuaPassword = usuaPassword;
    }

    public String getUsuaNombres() {
        return usuaNombres;
    }

    public void setUsuaNombres(String usuaNombres) {
        this.usuaNombres = usuaNombres;
    }

    public String getUsuaApellidos() {
        return usuaApellidos;
    }

    public void setUsuaApellidos(String usuaApellidos) {
        this.usuaApellidos = usuaApellidos;
    }

    public String getUsuaCedula() {
        return usuaCedula;
    }

    public void setUsuaCedula(String usuaCedula) {
        this.usuaCedula = usuaCedula;
    }

    public String getUsuaCiudad() {
        return usuaCiudad;
    }

    public void setUsuaCiudad(String usuaCiudad) {
        this.usuaCiudad = usuaCiudad;
    }

    public String getUsuaEstado() {
        return usuaEstado;
    }

    public void setUsuaEstado(String usuaEstado) {
        this.usuaEstado = usuaEstado;
    }

    @XmlTransient
    public List<Parqueo> getParqueoList() {
        return parqueoList;
    }

    public void setParqueoList(List<Parqueo> parqueoList) {
        this.parqueoList = parqueoList;
    }

    @XmlTransient
    public List<Facturas> getFacturasList() {
        return facturasList;
    }

    public void setFacturasList(List<Facturas> facturasList) {
        this.facturasList = facturasList;
    }

    public Roles getRolCodigo() {
        return rolCodigo;
    }

    public void setRolCodigo(Roles rolCodigo) {
        this.rolCodigo = rolCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuaCodigo != null ? usuaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.usuaCodigo == null && other.usuaCodigo != null) || (this.usuaCodigo != null && !this.usuaCodigo.equals(other.usuaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpaentity.Usuarios[ usuaCodigo=" + usuaCodigo + " ]";
    }
    
}
