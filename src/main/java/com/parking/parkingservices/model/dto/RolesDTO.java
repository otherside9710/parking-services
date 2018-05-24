package com.parking.parkingservices.model.dto;

import com.parking.parkingservices.model.entity.Roles;

public class RolesDTO {
    private Integer rolCodigo;
    private String rolDescripcion;

    public RolesDTO() {
    }

    public RolesDTO(Integer rolCodigo, String rolDescripcion) {
        this.rolCodigo = rolCodigo;
        this.rolDescripcion = rolDescripcion;
    }

    public static RolesDTO createFromEntity(Roles roles){
        return new RolesDTO(
                roles.getRolCodigo(),
                roles.getRolDescripcion()
        );
    }

    public Roles toEntity(){
        Roles roles = new Roles();
        roles.setRolCodigo(this.rolCodigo);
        roles.setRolDescripcion(this.rolDescripcion);
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
}
