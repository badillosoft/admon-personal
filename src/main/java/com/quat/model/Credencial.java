package com.quat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Credencial {

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    Integer id;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotNull
    @Column(unique=true)
    String correo;

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @NotNull
    String contraseña;

    public String getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    Integer max_intentos;

    public Integer getMax_intentos() {
        return this.max_intentos;
    }

    public void setMax_intentos(Integer max_intentos) {
        this.max_intentos = max_intentos;
    }

    Integer intentos;

    public Integer getIntentos() {
        return this.intentos;
    }

    public void setIntentos(Integer intentos) {
        this.intentos = intentos;
    }

}