package com.quat.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
    Personal personal;

    public Personal getPersonal() {
        return this.personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
    

    @OneToOne
    Credencial credencial;

    public Credencial getCredencial() {
        return this.credencial;
    }

    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }

    @ManyToMany
    Set<Perfil> perfiles;

    public Set<Perfil> getPerfiles() {
        return this.perfiles;
    }

    public void setPerfiles(Set<Perfil> perfiles) {
        this.perfiles = perfiles;
    }

    Boolean activo;

    public Boolean isActivo() {
        return this.activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

}