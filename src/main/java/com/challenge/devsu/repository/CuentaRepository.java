package com.challenge.devsu.repository;

import com.challenge.devsu.model.Cuenta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends CrudRepository<Cuenta, Long> {

}
