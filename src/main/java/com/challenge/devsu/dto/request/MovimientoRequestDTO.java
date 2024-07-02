package com.challenge.devsu.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class MovimientoRequestDTO {

    private Long id;

    private Date fecha;

    private Long tipoMovimientoId;

    private Double valor;

    private Double saldo;

    private Long cuentaId;
}
