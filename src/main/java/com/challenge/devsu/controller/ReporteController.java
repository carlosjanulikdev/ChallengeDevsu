package com.challenge.devsu.controller;

import com.challenge.devsu.dto.response.ReporteEstadoCuentaResponseDTO;
import com.challenge.devsu.service.IReporteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/reportes")
public class ReporteController {
    Logger logger = LoggerFactory.getLogger(ReporteController.class);

    private IReporteService reporteService;

    public ReporteController(IReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @GetMapping
    public List<ReporteEstadoCuentaResponseDTO> generarReporteEstadoCuenta(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaDesde,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaHasta,
            @RequestParam Long clienteId){
        logger.info("Generando reporte desde el:{} hasta el:{} para el cliente:{}", fechaDesde, fechaHasta, clienteId);

        return reporteService.reporteEstadoCuenta(fechaDesde, fechaHasta, clienteId);
    }

}
