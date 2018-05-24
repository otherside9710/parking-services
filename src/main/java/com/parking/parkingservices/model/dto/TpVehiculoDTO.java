package com.parking.parkingservices.model.dto;

import com.parking.parkingservices.model.entity.TpVehiculo;

public class TpVehiculoDTO {
    private Integer tpvCodigo;
    private String tpvDescripcion;

    public TpVehiculoDTO() {
    }

    public TpVehiculoDTO(Integer tpvCodigo, String tpvDescripcion) {
        this.tpvCodigo = tpvCodigo;
        this.tpvDescripcion = tpvDescripcion;
    }

    public static TpVehiculoDTO createFromEntity(TpVehiculo tp){
        return new TpVehiculoDTO(
                tp.getTpvCodigo(),
                tp.getTpvDescripcion()
        );
    }

    public TpVehiculo toEntity(){
        TpVehiculo tp = new TpVehiculo();
        tp.setTpvCodigo(this.tpvCodigo);
        tp.setTpvDescripcion(this.tpvDescripcion);
        return tp;
    }


    public Integer getTpvCodigo() {
        return tpvCodigo;
    }

    public void setTpvCodigo(Integer tpvCodigo) {
        this.tpvCodigo = tpvCodigo;
    }

    public String getTpvDescripcion() {
        return tpvDescripcion;
    }

    public void setTpvDescripcion(String tpvDescripcion) {
        this.tpvDescripcion = tpvDescripcion;
    }
}
