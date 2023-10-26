package com.Tristan.TipoCambio.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Tristan.TipoCambio.Dao.ITransaccionDao;
import com.Tristan.TipoCambio.Response.TransaccionResponseRest;
import com.Tristan.TipoCambio.model.Transaccion;

import jakarta.transaction.Transactional;

@Service
public class TransaccionServiceImpl implements ITransaccionService {

	private static final Logger Log = LoggerFactory.getLogger(TransaccionServiceImpl.class);
	
	@Autowired
	private ITransaccionDao transaccionDao;
	
	@Override
	@Transactional
	public ResponseEntity<TransaccionResponseRest> listarTransaccion() {
		
		Log.info("Inicio metodo listarTrasaccion()");
		
		TransaccionResponseRest response = new TransaccionResponseRest();
		
		try {
			List<Transaccion> transaccion = (List<Transaccion>) transaccionDao.findAll();
			
			response.getTransaccionResponse().setTransaccion(transaccion);
			
			response.setMetada("Respuesta ok", "00", "Respuesta exitosa");
		} catch (Exception e) {
			response.setMetada("Respuesta no ok", "-1", "Respuesta incorrecta");
			Log.error("Error al consultar entidad: ", e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<TransaccionResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
		return new ResponseEntity<TransaccionResponseRest>(response, HttpStatus.OK);
	}

}
