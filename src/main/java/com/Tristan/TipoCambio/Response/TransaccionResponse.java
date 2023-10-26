package com.Tristan.TipoCambio.Response;

import java.util.List;

import com.Tristan.TipoCambio.model.Transaccion;

public class TransaccionResponse {

	private List<Transaccion> transaccion;
	
	public List<Transaccion> getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(List<Transaccion> transaccion) {
		this.transaccion = transaccion;
	}
	
}
