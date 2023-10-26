package com.Tristan.TipoCambio.Response;

import java.util.List;

import com.Tristan.TipoCambio.model.TipoCambio;

public class TipoCambioResponse extends ResponseRest {
	
	private List<TipoCambio> tipoCambio;
	
	public List<TipoCambio> getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(List<TipoCambio> tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
}
