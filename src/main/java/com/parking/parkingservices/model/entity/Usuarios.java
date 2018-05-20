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
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findByUsuaCodigo", query = "SELECT u FROM Usuarios u WHERE u.usuariosPK.usuaCodigo = :usuaCodigo")
    , @NamedQuery(name = "Usuarios.findByUsuaNombres", query = "SELECT u FROM Usuarios u WHERE u.usuaNombres = :usuaNombres")
    , @NamedQuery(name = "Usuarios.findByUsuaApellidos", query = "SELECT u FROM Usuarios u WHERE u.usuaApellidos = :usuaApellidos")
    , @NamedQuery(name = "Usuarios.findByUsuaCedula", query = "SELECT u FROM Usuarios u WHERE u.usuaCedula = :usuaCedula")
    , @NamedQuery(name = "Usuarios.findByUsuaEstado", query = "SELECT u FROM Usuarios u WHERE u.usuaEstado = :usuaEstado")
    , @NamedQuery(name = "Usuarios.findByRolCodigo", query = "SELECT u FROM Usuarios u WHERE u.usuariosPK.rolCodigo = :rolCodigo")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuariosPK usuariosPK;
    @Column(name = "usua_nombres")
    private String usuaNombres;
    @Column(name = "usua_apellidos")
    private String usuaApellidos;
    @Column(name = "usua_cedula")
    private String usuaCedula;
    @Column(name = "usua_estado")
    private String usuaEstado;
    @JoinColumn(name = "fact_codigo", referencedColumnName = "fact_codigo")
    @ManyToOne(optional = false)
    private Facturas factCodigo;
    @JoinColumn(name = "rol_codigo", referencedColumnName = "rol_codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Roles roles;
    @JoinColumn(name = "ticket_codigo", referencedColumnName = "ticket_codigo")
    @ManyToOne(optional = false)
    private Ticket ticketCodigo;

    public Usuarios() {
    }

    public Usuarios(UsuariosPK usuariosPK) {
        this.usuariosPK = usuariosPK;
    }

    public Usuarios(int usuaCodigo, int rolCodigo) {
        this.usuariosPK = new UsuariosPK(usuaCodigo, rolCodigo);
    }

    public UsuariosPK getUsuariosPK() {
        return usuariosPK;
    }

    public void setUsuariosPK(UsuariosPK usuariosPK) {
        this.usuariosPK = usuariosPK;
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

    public String getUsuaEstado() {
        return usuaEstado;
    }

    public void setUsuaEstado(String usuaEstado) {
        this.usuaEstado = usuaEstado;
    }

    public Facturas getFactCodigo() {
        return factCodigo;
    }

    public void setFactCodigo(Facturas factCodigo) {
        this.factCodigo = factCodigo;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public Ticket getTicketCodigo() {
        return ticketCodigo;
    }

    public void setTicketCodigo(Ticket ticketCodigo) {
        this.ticketCodigo = ticketCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuariosPK != null ? usuariosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.usuariosPK == null && other.usuariosPK != null) || (this.usuariosPK != null && !this.usuariosPK.equals(other.usuariosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpaentity.Usuarios[ usuariosPK=" + usuariosPK + " ]";
    }
    
}
