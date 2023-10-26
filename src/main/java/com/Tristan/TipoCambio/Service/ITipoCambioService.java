package com.Tristan.TipoCambio.Service;

import org.springframework.http.ResponseEntity;

import com.Tristan.TipoCambio.Response.TipoCambioResponseRest;

public interface ITipoCambioService {
	
	public ResponseEntity<TipoCambioResponseRest> listarTipoCambio();
}
