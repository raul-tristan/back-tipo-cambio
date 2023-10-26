package com.Tristan.TipoCambio.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tristan.TipoCambio.Response.TransaccionResponseRest;
import com.Tristan.TipoCambio.Service.ITransaccionService;

@RestController
@RequestMapping("/v1")
public class TransaccionRestController {
	
	@Autowired
	private ITransaccionService service;
	
	@GetMapping("/transaccion")
	public ResponseEntity<TransaccionResponseRest> listarTra() {
		
		ResponseEntity<TransaccionResponseRest> response = service.listarTransaccion();
		return response;
	}
}
