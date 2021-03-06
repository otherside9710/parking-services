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
@Table(name = "vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v")
    , @NamedQuery(name = "Vehiculo.findByVehCodigo", query = "SELECT v FROM Vehiculo v WHERE v.vehCodigo = :vehCodigo")
    , @NamedQuery(name = "Vehiculo.findByVehPlaca", query = "SELECT v FROM Vehiculo v WHERE v.vehPlaca = :vehPlaca")
    , @NamedQuery(name = "Vehiculo.findByVehEstado", query = "SELECT v FROM Vehiculo v WHERE v.vehEstado = :vehEstado")})
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "veh_codigo")
    private Integer vehCodigo;
    @Basic(optional = false)
    @Column(name = "veh_placa")
    private String vehPlaca;
    @Column(name = "veh_estado")
    private String vehEstado;
    @OneToMany(mappedBy = "vehCodigo")
    private List<Parqueo> parqueoList;
    @JoinColumn(name = "zona_codigo", referencedColumnName = "zona_codigo")
    @ManyToOne
    private Zonas zonaCodigo;
    @JoinColumn(name = "clie_codigo", referencedColumnName = "clie_codigo")
    @ManyToOne
    private Clientes clieCodigo;
    @JoinColumn(name = "tpv_codigo", referencedColumnName = "tpv_codigo")
    @ManyToOne(optional = false)
    private TpVehiculo tpvCodigo;

    public Vehiculo() {
    }

    public Vehiculo(Integer vehCodigo) {
        this.vehCodigo = vehCodigo;
    }

    public Vehiculo(Integer vehCodigo, String vehPlaca) {
        this.vehCodigo = vehCodigo;
        this.vehPlaca = vehPlaca;
    }

    public Integer getVehCodigo() {
        return vehCodigo;
    }

    public void setVehCodigo(Integer vehCodigo) {
        this.vehCodigo = vehCodigo;
    }

    public String getVehPlaca() {
        return vehPlaca;
    }

    public void setVehPlaca(String vehPlaca) {
        this.vehPlaca = vehPlaca;
    }

    public String getVehEstado() {
        return vehEstado;
    }

    public void setVehEstado(String vehEstado) {
        this.vehEstado = vehEstado;
    }

    @XmlTransient
    public List<Parqueo> getParqueoList() {
        return parqueoList;
    }

    public void setParqueoList(List<Parqueo> parqueoList) {
        this.parqueoList = parqueoList;
    }

    public Zonas getZonaCodigo() {
        return zonaCodigo;
    }

    public void setZonaCodigo(Zonas zonaCodigo) {
        this.zonaCodigo = zonaCodigo;
    }

    public Clientes getClieCodigo() {
        return clieCodigo;
    }

    public void setClieCodigo(Clientes clieCodigo) {
        this.clieCodigo = clieCodigo;
    }

    public TpVehiculo getTpvCodigo() {
        return tpvCodigo;
    }

    public void setTpvCodigo(TpVehiculo tpvCodigo) {
        this.tpvCodigo = tpvCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vehCodigo != null ? vehCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.vehCodigo == null && other.vehCodigo != null) || (this.vehCodigo != null && !this.vehCodigo.equals(other.vehCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpaentity.Vehiculo[ vehCodigo=" + vehCodigo + " ]";
    }
    
}
