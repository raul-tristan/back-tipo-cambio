package com.Tristan.TipoCambio.Service;

import java.util.ArrayList;
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

	@Override
	@Transactional
	public ResponseEntity<TipoCambioResponseRest> crear(TipoCambio tipoCambio) {

		Log.info("Inicio método crear tipoCambio");
		
		TipoCambioResponseRest response = new TipoCambioResponseRest();
		List<TipoCambio> list = new ArrayList<>();
		
		try {
			
			TipoCambio tipoCambioGuardada = tipoCambioDao.save(tipoCambio);
			
			if (tipoCambioGuardada != null) {
				list.add(tipoCambioGuardada);
				response.getTipoCambioResponse().setTipoCambio(list);
			} else {
				Log.error("Error en grabar el tipo cambio");
				response.setMetada("Respuesta no ok", "-1", "Tipo cambio no guardado");
				return new ResponseEntity<TipoCambioResponseRest>(response, HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			Log.error("Error en grabar el tipo de cambio");
			response.setMetada("Respuesta no ok", "-1", "Error en grabar tipo de cambio");
			return new ResponseEntity<TipoCambioResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.setMetada("Respuesta ok", "00", "Tipo cambio creada");
		return new ResponseEntity<TipoCambioResponseRest>(response, HttpStatus.OK);
	}

	
	
	@Override
	public ResponseEntity<TipoCambioResponseRest> actualizar(TipoCambio tipoCambio, Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
