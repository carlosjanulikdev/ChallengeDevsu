package com.challenge.devsu.repository;

import com.challenge.devsu.model.Movimiento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MovimientoRepository extends CrudRepository<Movimiento, Long> {

    List<Movimiento> findByCuentaIdOrderByIdDesc(Long cuentaId);

    @Query("  SELECT m " +
            "     FROM Movimiento m " +
            "    WHERE m.cuenta.cliente.id = :clienteId " +
            "      AND m.fecha BETWEEN :fechaDesde AND :fechaHasta" +
            " ORDER BY m.fecha, m.cuenta.id")
    List<Movimiento> findMovimientosByClienteAndFecha(Date fechaDesde, Date fechaHasta, Long clienteId);
}
