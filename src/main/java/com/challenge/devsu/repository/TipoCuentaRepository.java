package com.challenge.devsu.repository;

import com.challenge.devsu.model.TipoCuenta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCuentaRepository extends CrudRepository<TipoCuenta, Long> {

}
