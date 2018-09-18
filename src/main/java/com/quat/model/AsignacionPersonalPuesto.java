package com.quat.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class AsignacionPersonalPuesto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	
	@ManyToOne
	@NotNull
	Personal personal;
	
	@ManyToOne
	@NotNull
	Puesto puesto;
	
	@NotNull
	Float salario;
	
	@NotNull
	Timestamp fecha_asignacion;
	
	Timestamp fecha_desasignacion;
	
	String motivo_desagnacion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	public Puesto getPuesto() {
		return puesto;
	}

	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}

	public Float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}

	public Timestamp getFecha_asignacion() {
		return fecha_asignacion;
	}

	public void setFecha_asignacion(Timestamp fecha_asignacion) {
		this.fecha_asignacion = fecha_asignacion;
	}

	public Timestamp getFecha_desasignacion() {
		return fecha_desasignacion;
	}

	public void setFecha_desasignacion(Timestamp fecha_desasignacion) {
		this.fecha_desasignacion = fecha_desasignacion;
	}

	public String getMotivo_desagnacion() {
		return motivo_desagnacion;
	}

	public void setMotivo_desagnacion(String motivo_desagnacion) {
		this.motivo_desagnacion = motivo_desagnacion;
	}
	
}
