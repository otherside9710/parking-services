package com.parking.parkingservices.model.dto;

import com.parking.parkingservices.model.entity.*;

public class VehiculosDTO {
    private Integer vehCodigo;
    private String vehPlaca;
    private String vehEstado;
    private Integer zonaCodigo;
    private Integer parCodigo;
    private Integer tpvCodigo;
    private Integer clieCodigo;

    public VehiculosDTO() {
    }

    public VehiculosDTO(Integer vehCodigo, String vehPlaca, String vehEstado,
                        Integer zonaCodigo, Integer parCodigo, Integer tpvCodigo, Integer clieCodigo) {
        this.vehCodigo = vehCodigo;
        this.vehPlaca = vehPlaca;
        this.vehEstado = vehEstado;
        this.zonaCodigo = zonaCodigo;
        this.parCodigo = parCodigo;
        this.tpvCodigo = tpvCodigo;
        this.clieCodigo = clieCodigo;
    }

    public static VehiculosDTO createFromEntity(Vehiculo vehiculo){
        return new VehiculosDTO(
                vehiculo.getVehCodigo(),
                vehiculo.getVehPlaca(),
                vehiculo.getVehEstado(),
                vehiculo.getZonaCodigo().getZonaCodigo(),
                vehiculo.getParCodigo().getParCodigo(),
                vehiculo.getTpvCodigo().getTpvCodigo(),
                vehiculo.getClieCodigo().getClieCodigo()
        );
    }

    public Vehiculo toEntity(){
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setVehCodigo(this.vehCodigo);
        vehiculo.setVehPlaca(this.vehPlaca);
        vehiculo.setVehEstado(this.vehEstado);

        Zonas zonas = new Zonas();
        zonas.setZonaCodigo(this.zonaCodigo);

        vehiculo.setZonaCodigo(zonas);

        Parqueo parqueo = new Parqueo();
        parqueo.setParCodigo(this.parCodigo);

        vehiculo.setParCodigo(parqueo);

        TpVehiculo tpVehiculo = new TpVehiculo();
        tpVehiculo.setTpvCodigo(this.tpvCodigo);

        vehiculo.setTpvCodigo(tpVehiculo);

        Clientes clientes = new Clientes();
        clientes.setClieCodigo(this.clieCodigo);

        vehiculo.setClieCodigo(clientes);

        return vehiculo;
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

    public Integer getZonaCodigo() {
        return zonaCodigo;
    }

    public void setZonaCodigo(Integer zonaCodigo) {
        this.zonaCodigo = zonaCodigo;
    }

    public Integer getParCodigo() {
        return parCodigo;
    }

    public void setParCodigo(Integer parCodigo) {
        this.parCodigo = parCodigo;
    }

    public Integer getTpvCodigo() {
        return tpvCodigo;
    }

    public void setTpvCodigo(Integer tpvCodigo) {
        this.tpvCodigo = tpvCodigo;
    }

    public Integer getClieCodigo() {
        return clieCodigo;
    }

    public void setClieCodigo(Integer clieCodigo) {
        this.clieCodigo = clieCodigo;
    }
}
