package com.Tristan.TipoCambio.Dao;

import org.springframework.data.repository.CrudRepository;

import com.Tristan.TipoCambio.model.Transaccion;

public interface ITransaccionDao extends CrudRepository<Transaccion, Long> {

}
