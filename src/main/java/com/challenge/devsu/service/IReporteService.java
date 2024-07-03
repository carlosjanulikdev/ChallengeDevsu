package com.challenge.devsu.service;

import com.challenge.devsu.dto.response.ReporteEstadoCuentaResponseDTO;

import java.util.Date;
import java.util.List;

public interface IReporteService {

    List<ReporteEstadoCuentaResponseDTO> reporteEstadoCuenta(Date fechaDesde, Date fechaHasta, Long clienteId);
}
