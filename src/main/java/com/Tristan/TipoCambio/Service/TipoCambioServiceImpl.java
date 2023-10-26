package com.Tristan.TipoCambio.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Tristan.TipoCambio.Dao.ITipoCambioDao;
import com.Tristan.TipoCambio.Response.TipoCambioResponseRest;
import com.Tristan.TipoCambio.model.TipoCambio;

import jakarta.transaction.Transactional;

@Service
public class TipoCambioServiceImpl implements ITipoCambioService {
	
	private static final Logger Log = LoggerFactory.getLogger(TipoCambioServiceImpl.class);
	
	@Autowired
	private ITipoCambioDao tipoCambioDao;
	
	@Override
	@Transactional
	public ResponseEntity<TipoCambioResponseRest> listarTipoCambio() {

		Log.info("Inicio metodo tipo cambio()");
		
		TipoCambioResponseRest response = new TipoCambioResponseRest();
		
		try {
			List<TipoCambio> tipoCambio = (List<TipoCambio>) tipoCambioDao.findAll();
			
			response.getTipoCambioResponse().setTipoCambio(tipoCambio);
			
			response.setMetada("Respuesta ok", "00", "Respuesta exitosa");
		} catch (Exception e) {
			response.setMetada("Respuesta no ok", "-1", "Respuesta incorrecta");
			Log.error("Error al consultar tipo documento: ", e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<TipoCambioResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
		return new ResponseEntity<TipoCambioResponseRest>(response, HttpStatus.OK);
	}
	
	
}
