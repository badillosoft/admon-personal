package com.quat.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Proyecto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	
	@NotNull
	String nombre;
	
	String descripcion;
	
	@NotNull
	Timestamp fecha_inicio;
	
	Timestamp fecha_entrega;
	
	Float presupuesto;
	
	Float retorno_esperado;

	Boolean activo;

	public Boolean isActivo() {
		return this.activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Timestamp getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Timestamp fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Timestamp getFecha_entrega() {
		return fecha_entrega;
	}

	public void setFecha_entrega(Timestamp fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}

	public Float getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(Float presupuesto) {
		this.presupuesto = presupuesto;
	}

	public Float getRetorno_esperado() {
		return retorno_esperado;
	}

	public void setRetorno_esperado(Float retorno_esperado) {
		this.retorno_esperado = retorno_esperado;
	}
	
}
