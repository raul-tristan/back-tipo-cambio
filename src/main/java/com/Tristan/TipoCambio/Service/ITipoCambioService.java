package com.Tristan.TipoCambio.Service;

import org.springframework.http.ResponseEntity;

import com.Tristan.TipoCambio.Response.TipoCambioResponseRest;
import com.Tristan.TipoCambio.model.TipoCambio;

public interface ITipoCambioService {
	
	public ResponseEntity<TipoCambioResponseRest> listarTipoCambio();
	public ResponseEntity<TipoCambioResponseRest> crear(TipoCambio tipoCambio);
	public ResponseEntity<TipoCambioResponseRest> actualizar(TipoCambio tipoCambio, Long id);
}
