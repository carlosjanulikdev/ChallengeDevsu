package com.challenge.devsu.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class MovimientoResponseDTO {

    private Long id;

    private Date fecha;

    private Double valor;

    private Double saldo;

    private CuentaMovimientoResponseDTO cuenta;

}
