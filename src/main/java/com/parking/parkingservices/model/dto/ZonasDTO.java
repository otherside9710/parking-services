package com.parking.parkingservices.model.dto;

import com.parking.parkingservices.model.entity.Zonas;

public class ZonasDTO {
    private Integer zonaCodigo;
    private String zonaDescripcion;
    private String zonaEstado;

    public ZonasDTO() {
    }

    public ZonasDTO(Integer zonaCodigo, String zonaDescripcion, String zonaEstado) {
        this.zonaCodigo = zonaCodigo;
        this.zonaDescripcion = zonaDescripcion;
        this.zonaEstado = zonaEstado;
    }

    public static ZonasDTO createFromEntity(Zonas zonas){
        return new ZonasDTO(
                zonas.getZonaCodigo(),
                zonas.getZonaDescripcion(),
                zonas.getZonaEstado()
        );
    }

    public Zonas toEntity(){
        Zonas zonas = new Zonas();
        zonas.setZonaCodigo(this.zonaCodigo);
        zonas.setZonaDescripcion(this.zonaDescripcion);
        zonas.setZonaEstado(this.zonaEstado);
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

}
