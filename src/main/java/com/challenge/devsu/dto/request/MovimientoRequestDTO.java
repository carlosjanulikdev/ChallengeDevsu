package com.challenge.devsu.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class MovimientoRequestDTO {

    private Date fecha;

    private Long tipoMovimientoId;

    private Double valor;

    private Long cuentaId;
}
