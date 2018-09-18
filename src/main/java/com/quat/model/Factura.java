package com.quat.model;

import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Factura {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	
	@NotNull
	String rfc_emisor;
	
	@NotNull
	String folio;
	
	@NotNull
	Blob pdf;
	
	@NotNull
	Blob xml;
	
	Float subtotal;
	
	Float iva_retenido;
	
	Float isr_retenido;
	
	Float iva_transladado;
	
	Float isr_transladado;
	
	Float total;
	
	@NotNull
	Timestamp fecha_facturacion;
	
	@NotNull
	String estatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRfc_emisor() {
		return rfc_emisor;
	}

	public void setRfc_emisor(String rfc_emisor) {
		this.rfc_emisor = rfc_emisor;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public Blob getPdf() {
		return pdf;
	}

	public void setPdf(Blob pdf) {
		this.pdf = pdf;
	}

	public Blob getXml() {
		return xml;
	}

	public void setXml(Blob xml) {
		this.xml = xml;
	}

	public Float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}

	public Float getIva_retenido() {
		return iva_retenido;
	}

	public void setIva_retenido(Float iva_retenido) {
		this.iva_retenido = iva_retenido;
	}

	public Float getIsr_retenido() {
		return isr_retenido;
	}

	public void setIsr_retenido(Float isr_retenido) {
		this.isr_retenido = isr_retenido;
	}

	public Float getIva_transladado() {
		return iva_transladado;
	}

	public void setIva_transladado(Float iva_transladado) {
		this.iva_transladado = iva_transladado;
	}

	public Float getIsr_transladado() {
		return isr_transladado;
	}

	public void setIsr_transladado(Float isr_transladado) {
		this.isr_transladado = isr_transladado;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Timestamp getFecha_facturacion() {
		return fecha_facturacion;
	}

	public void setFecha_facturacion(Timestamp fecha_facturacion) {
		this.fecha_facturacion = fecha_facturacion;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
}
