package com.quat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Usuario {

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    Integer id;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne
    Credencial credencial;

    public Credencial getCredencial() {
        return this.credencial;
    }

    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }

    @OneToOne
    Perfil perfil;

    public Perfil getPerfil() {
        return this.perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    Boolean activo;

    public Boolean isActivo() {
        return this.activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

}