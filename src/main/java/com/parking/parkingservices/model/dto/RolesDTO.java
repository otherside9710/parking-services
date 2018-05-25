package com.parking.parkingservices.model.dto;

import com.parking.parkingservices.model.entity.Roles;

public class RolesDTO {
    private Integer rolCodigo;
    private String rolDescripcion;
    private String rolEstado;

    public RolesDTO() {
    }

    public RolesDTO(Integer rolCodigo, String rolDescripcion, String rolEstado) {
        this.rolCodigo = rolCodigo;
        this.rolDescripcion = rolDescripcion;
        this.rolEstado = rolEstado;
    }

    public static RolesDTO createFromEntity(Roles roles){
        return new RolesDTO(
                roles.getRolCodigo(),
                roles.getRolDescripcion(),
                roles.getRolEstado()
        );
    }

    public Roles toEntity(){
        Roles roles = new Roles();
        roles.setRolCodigo(this.rolCodigo);
        roles.setRolDescripcion(this.rolDescripcion);
        roles.setRolEstado(this.rolEstado);
        return roles;
    }

    public Integer getRolCodigo() {
        return rolCodigo;
    }

    public void setRolCodigo(Integer rolCodigo) {
        this.rolCodigo = rolCodigo;
    }

    public String getRolDescripcion() {
        return rolDescripcion;
    }

    public void setRolDescripcion(String rolDescripcion) {
        this.rolDescripcion = rolDescripcion;
    }

    public String getRolEstado() {
        return rolEstado;
    }

    public void setRolEstado(String rolEstado) {
        this.rolEstado = rolEstado;
    }
}
