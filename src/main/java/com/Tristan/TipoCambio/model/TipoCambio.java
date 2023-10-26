package com.Tristan.TipoCambio.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tipo_cambio")
public class TipoCambio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 683388854723191601L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 8)
	private double monto;
	
	@Column(length = 15)
	private String modenaOrigen;
	
	@Column(length = 15)
	private String modenaDestino;
		
	@Column(length = 5)
	private double tasa;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getModenaOrigen() {
		return modenaOrigen;
	}

	public void setModenaOrigen(String modenaOrigen) {
		this.modenaOrigen = modenaOrigen;
	}

	public String getModenaDestino() {
		return modenaDestino;
	}

	public void setModenaDestino(String modenaDestino) {
		this.modenaDestino = modenaDestino;
	}

	public double getTasa() {
		return tasa;
	}

	public void setTasa(double tasa) {
		this.tasa = tasa;
	}
		
}
