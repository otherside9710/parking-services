package com.parking.parkingservices.model.dto;

public class ClientesVsVehiculos {
    private Integer clieCodigo;
    private String clieNombres;
    private String clieApellidos;
    private String clieCedula;
    private String clieTelefono;
    private String clieCiudad;
    private String clieDireccion;
    private String clieEmail;
    private String clieEstado;
    //Vehiculo
    private Integer vehCodigo;
    private String vehPlaca;
    private String vehEstado;
    private Integer zonaCodigo;
    private Integer tpvCodigo;
    private Integer clieCodigoVeh;

    public ClientesVsVehiculos(){}

    public ClientesVsVehiculos(Integer clieCodigo, String clieNombres, String clieApellidos, String clieCedula,
                               String clieTelefono, String clieCiudad, String clieDireccion, String clieEmail, String clieEstado,
                               Integer vehCodigo, String vehPlaca, String vehEstado, Integer zonaCodigo,
                               Integer tpvCodigo, Integer clieCodigoVeh) {
        this.clieCodigo = clieCodigo;
        this.clieNombres = clieNombres;
        this.clieApellidos = clieApellidos;
        this.clieCedula = clieCedula;
        this.clieTelefono = clieTelefono;
        this.clieCiudad = clieCiudad;
        this.clieDireccion = clieDireccion;
        this.clieEmail = clieEmail;
        this.clieEstado = clieEstado;
        this.vehCodigo = vehCodigo;
        this.vehPlaca = vehPlaca;
        this.vehEstado = vehEstado;
        this.zonaCodigo = zonaCodigo;
        this.tpvCodigo = tpvCodigo;
        this.clieCodigoVeh = clieCodigoVeh;
    }

    public Integer getClieCodigo() {
        return clieCodigo;
    }

    public void setClieCodigo(Integer clieCodigo) {
        this.clieCodigo = clieCodigo;
    }

    public String getClieNombres() {
        return clieNombres;
    }

    public void setClieNombres(String clieNombres) {
        this.clieNombres = clieNombres;
    }

    public String getClieApellidos() {
        return clieApellidos;
    }

    public void setClieApellidos(String clieApellidos) {
        this.clieApellidos = clieApellidos;
    }

    public String getClieCedula() {
        return clieCedula;
    }

    public void setClieCedula(String clieCedula) {
        this.clieCedula = clieCedula;
    }

    public String getClieTelefono() {
        return clieTelefono;
    }

    public void setClieTelefono(String clieTelefono) {
        this.clieTelefono = clieTelefono;
    }

    public String getClieCiudad() {
        return clieCiudad;
    }

    public void setClieCiudad(String clieCiudad) {
        this.clieCiudad = clieCiudad;
    }

    public String getClieDireccion() {
        return clieDireccion;
    }

    public void setClieDireccion(String clieDireccion) {
        this.clieDireccion = clieDireccion;
    }

    public String getClieEmail() {
        return clieEmail;
    }

    public void setClieEmail(String clieEmail) {
        this.clieEmail = clieEmail;
    }

    public String getClieEstado() {
        return clieEstado;
    }

    public void setClieEstado(String clieEstado) {
        this.clieEstado = clieEstado;
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

    public Integer getTpvCodigo() {
        return tpvCodigo;
    }

    public void setTpvCodigo(Integer tpvCodigo) {
        this.tpvCodigo = tpvCodigo;
    }

    public Integer getClieCodigoVeh() {
        return clieCodigoVeh;
    }

    public void setClieCodigoVeh(Integer clieCodigoVeh) {
        this.clieCodigoVeh = clieCodigoVeh;
    }
}
