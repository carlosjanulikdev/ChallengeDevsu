package com.challenge.devsu.repository;

import com.challenge.devsu.model.TipoCuenta;
import com.challenge.devsu.model.TipoMovimiento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoMovimientoRepository extends CrudRepository<TipoMovimiento, Long> {

}
