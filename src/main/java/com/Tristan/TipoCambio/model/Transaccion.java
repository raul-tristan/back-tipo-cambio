package com.Tristan.TipoCambio.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_transaccion")
public class Transaccion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 553975365195318243L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 10)
	private double montoConvertido;
	
	@Column(length = 10)
	private String guardarPrueba;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private TipoCambio tipocambio;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getMontoConvertido() {
		return montoConvertido;
	}

	public void setMontoConvertido(double montoConvertido) {
		this.montoConvertido = montoConvertido;
	}

	public String getGuardarPrueba() {
		return guardarPrueba;
	}

	public void setGuardarPrueba(String guardarPrueba) {
		this.guardarPrueba = guardarPrueba;
	}

	public TipoCambio getTipocambio() {
		return tipocambio;
	}

	public void setTipocambio(TipoCambio tipocambio) {
		this.tipocambio = tipocambio;
	}

	
	

	
	
}
