package com.challenge.devsu.service.impl;

import com.challenge.devsu.dto.response.ReporteEstadoCuentaResponseDTO;
import com.challenge.devsu.model.Movimiento;
import com.challenge.devsu.repository.MovimientoRepository;
import com.challenge.devsu.service.IReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReporteService implements IReporteService {

    private MovimientoRepository movimientoRepository;

    public ReporteService(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }

    public List<ReporteEstadoCuentaResponseDTO> reporteEstadoCuenta(Date fechaDesde, Date fechaHasta, Long clienteId){
        List<Movimiento> movimientos = movimientoRepository.findMovimientosByClienteAndFecha(
                fechaDesde, fechaHasta, clienteId);

        return movimientos.stream().map( movimiento ->
                    ReporteEstadoCuentaResponseDTO.builder()
                            .fecha(movimiento.getFecha())
                            .cliente(movimiento.getCuenta().getCliente().getNombre())
                            .numeroCuenta(movimiento.getCuenta().getNumero())
                            .tipo(movimiento.getCuenta().getTipoCuenta().getDescripcion())
                            .saldoInicial(movimiento.getCuenta().getSaldoInicial())
                            .estado(movimiento.getCuenta().getEstado())
                            .movimiento(movimiento.getValor())
                            .saldoDisponible(movimiento.getSaldo())
                        .build())
                .toList();
    }

}
