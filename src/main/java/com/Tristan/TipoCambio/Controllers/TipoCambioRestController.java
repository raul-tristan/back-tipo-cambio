package com.Tristan.TipoCambio.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tristan.TipoCambio.Response.TipoCambioResponseRest;
import com.Tristan.TipoCambio.Service.ITipoCambioService;
import com.Tristan.TipoCambio.model.TipoCambio;

@RestController
@RequestMapping("/v1")
public class TipoCambioRestController {
	
	@Autowired
	private ITipoCambioService service;
	
	@GetMapping("/tipo_cambio")
	public ResponseEntity<TipoCambioResponseRest> listarTipoCambio() {
		ResponseEntity<TipoCambioResponseRest> response = service.listarTipoCambio();
		return response;
	}
	
	@PostMapping("/tipo_cambio")
	public ResponseEntity<TipoCambioResponseRest> crear(@RequestBody TipoCambio request) {
		ResponseEntity<TipoCambioResponseRest> response = service.crear(request);
		return response;
	}
	
	@PutMapping("/tipo_cambio/{id}") 
	public ResponseEntity<TipoCambioResponseRest> actualizar(@RequestBody TipoCambio request, @PathVariable Long id) {
		ResponseEntity<TipoCambioResponseRest> response = service.actualizar(request, id);
		return response;
	}
	
}
