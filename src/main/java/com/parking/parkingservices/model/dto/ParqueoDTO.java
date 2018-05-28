package com.parking.parkingservices.model.dto;

import com.parking.parkingservices.model.entity.*;

import java.util.Date;

public class ParqueoDTO {
    private Integer parCodigo;
    private Date parHinicio;
    private Date parHfinal;
    private String parEstado;
    private String parObservacion;
    private Integer usuaCodigo;
    private Integer vehCodigo;
    private Integer zonaCodigo;

    public ParqueoDTO(){}

    public ParqueoDTO(Integer parCodigo, Date parHinicio, Date parHfinal, String parEstado,
                      String parObservacion,  Integer usuaCodigo,
                      Integer vehCodigo, Integer zonaCodigo) {
        this.parCodigo = parCodigo;
        this.parHinicio = parHinicio;
        this.parHfinal = parHfinal;
        this.parEstado = parEstado;
        this.parObservacion = parObservacion;
        this.usuaCodigo = usuaCodigo;
        this.vehCodigo = vehCodigo;
        this.zonaCodigo = zonaCodigo;
    }

    public static ParqueoDTO createFromEntity(Parqueo parqueo){
        return new ParqueoDTO(
                parqueo.getParCodigo(),
                parqueo.getParHinicio(),
                parqueo.getParHfinal(),
                parqueo.getParEstado(),
                parqueo.getParObservacion(),
                parqueo.getUsuaCodigo().getUsuaCodigo(),
                parqueo.getVehCodigo().getVehCodigo(),
                parqueo.getZonaCodigo().getZonaCodigo()
        );
    }

    public Parqueo toEntity(){
        Parqueo parqueo = new Parqueo();
        parqueo.setParCodigo(this.parCodigo);
        parqueo.setParHinicio(this.parHinicio);
        parqueo.setParHfinal(this.parHfinal);
        parqueo.setParEstado(this.parEstado);
        parqueo.setParObservacion(this.parObservacion);

        Usuarios usuarios = new Usuarios();
        usuarios.setUsuaCodigo(this.usuaCodigo);

        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setVehCodigo(this.vehCodigo);

        Zonas zonas = new Zonas();
        zonas.setZonaCodigo(this.zonaCodigo);

        parqueo.setUsuaCodigo(usuarios);
        parqueo.setVehCodigo(vehiculo);
        parqueo.setZonaCodigo(zonas);

        return parqueo;
    }

    public Integer getParCodigo() {
        return parCodigo;
    }

    public void setParCodigo(Integer parCodigo) {
        this.parCodigo = parCodigo;
    }

    public Date getParHinicio() {
        return parHinicio;
    }

    public void setParHinicio(Date parHinicio) {
        this.parHinicio = parHinicio;
    }

    public Date getParHfinal() {
        return parHfinal;
    }

    public void setParHfinal(Date parHfinal) {
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

    public Integer getUsuaCodigo() {
        return usuaCodigo;
    }

    public void setUsuaCodigo(Integer usuaCodigo) {
        this.usuaCodigo = usuaCodigo;
    }

    public Integer getVehCodigo() {
        return vehCodigo;
    }

    public void setVehCodigo(Integer vehCodigo) {
        this.vehCodigo = vehCodigo;
    }

    public Integer getZonaCodigo() {
        return zonaCodigo;
    }

    public void setZonaCodigo(Integer zonaCodigo) {
        this.zonaCodigo = zonaCodigo;
    }
}
