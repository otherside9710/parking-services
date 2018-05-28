package com.parking.parkingservices.model.dto;

import com.parking.parkingservices.model.entity.Roles;
import com.parking.parkingservices.model.entity.Usuarios;

public class UsuariosDTO {
    private Integer usuaCodigo;
    private String usuaPassword;
    private String usuaNombres;
    private String usuaApellidos;
    private String usuaCedula;
    private String usuaCiudad;
    private String usuaEstado;
    private Integer rolCodigo;

    public UsuariosDTO() {
    }

    public UsuariosDTO(Integer usuaCodigo, String usuaPassword, String usuaNombres,
                       String usuaApellidos, String usuaCedula, String usuaCiudad,
                       String usuaEstado, Integer rolCodigo) {
        this.usuaCodigo = usuaCodigo;
        this.usuaPassword = usuaPassword;
        this.usuaNombres = usuaNombres;
        this.usuaApellidos = usuaApellidos;
        this.usuaCedula = usuaCedula;
        this.usuaCiudad = usuaCiudad;
        this.usuaEstado = usuaEstado;
        this.rolCodigo = rolCodigo;
    }

    public static UsuariosDTO createFromEntity(Usuarios usuarios){
        return new UsuariosDTO(
                usuarios.getUsuaCodigo(),
                usuarios.getUsuaPassword(),
                usuarios.getUsuaNombres(),
                usuarios.getUsuaApellidos(),
                usuarios.getUsuaCedula(),
                usuarios.getUsuaCiudad(),
                usuarios.getUsuaEstado(),
                usuarios.getRolCodigo().getRolCodigo()
        );
    }

    public Usuarios toEntity(){
        Usuarios usuarios = new Usuarios();

        usuarios.setUsuaCodigo(this.usuaCodigo);
        usuarios.setUsuaPassword(this.usuaPassword);
        usuarios.setUsuaNombres(this.usuaNombres);
        usuarios.setUsuaApellidos(this.usuaApellidos);
        usuarios.setUsuaCedula(this.usuaCedula);
        usuarios.setUsuaCiudad(this.usuaCiudad);
        usuarios.setUsuaEstado(this.usuaEstado);

        Roles roles = new Roles();
        roles.setRolCodigo(this.rolCodigo);

        usuarios.setRolCodigo(roles);

        return usuarios;
    }

    public Integer getUsuaCodigo() {
        return usuaCodigo;
    }

    public void setUsuaCodigo(Integer usuaCodigo) {
        this.usuaCodigo = usuaCodigo;
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

    public Integer getRolCodigo() {
        return rolCodigo;
    }

    public void setRolCodigo(Integer rolCodigo) {
        this.rolCodigo = rolCodigo;
    }

    public String getUsuaPassword() {
        return usuaPassword;
    }

    public void setUsuaPassword(String usuaPassword) {
        this.usuaPassword = usuaPassword;
    }
}
