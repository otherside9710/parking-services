package com.parking.parkingservices.model.dto;

import com.parking.parkingservices.model.entity.Parqueo;
import com.parking.parkingservices.model.entity.Zonas;

public class ZonasDTO {
    private Integer zonaCodigo;
    private String zonaDescripcion;
    private String zonaEstado;
    private Integer parCodigo;

    public ZonasDTO() {
    }

    public ZonasDTO(Integer zonaCodigo, String zonaDescripcion, String zonaEstado, Integer parCodigo) {
        this.zonaCodigo = zonaCodigo;
        this.zonaDescripcion = zonaDescripcion;
        this.zonaEstado = zonaEstado;
        this.parCodigo = parCodigo;
    }

    public static ZonasDTO createFromEntity(Zonas zonas){
        return new ZonasDTO(
                zonas.getZonaCodigo(),
                zonas.getZonaDescripcion(),
                zonas.getZonaEstado(),
                zonas.getParCodigo().getParCodigo()
        );
    }

    public Zonas toEntity(){
        Zonas zonas = new Zonas();
        zonas.setZonaCodigo(this.zonaCodigo);
        zonas.setZonaDescripcion(this.zonaDescripcion);
        zonas.setZonaEstado(this.zonaEstado);

        Parqueo parqueo = new Parqueo();
        parqueo.setParCodigo(this.parCodigo);

        zonas.setParCodigo(parqueo);
        return zonas;
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

    public Integer getParCodigo() {
        return parCodigo;
    }

    public void setParCodigo(Integer parCodigo) {
        this.parCodigo = parCodigo;
    }
}
