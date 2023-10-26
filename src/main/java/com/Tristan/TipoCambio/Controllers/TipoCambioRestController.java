package com.Tristan.TipoCambio.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tristan.TipoCambio.Response.TipoCambioResponseRest;
import com.Tristan.TipoCambio.Service.ITipoCambioService;

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
}
