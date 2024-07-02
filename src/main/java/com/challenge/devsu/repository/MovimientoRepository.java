package com.challenge.devsu.repository;

import com.challenge.devsu.model.Cuenta;
import com.challenge.devsu.model.Movimiento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRepository extends CrudRepository<Movimiento, Long> {

}
