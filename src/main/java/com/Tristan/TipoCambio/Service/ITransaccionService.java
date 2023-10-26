package com.Tristan.TipoCambio.Service;

import org.springframework.http.ResponseEntity;

import com.Tristan.TipoCambio.Response.TransaccionResponseRest;

public interface ITransaccionService {
	
	public ResponseEntity<TransaccionResponseRest> listarTransaccion();
}
