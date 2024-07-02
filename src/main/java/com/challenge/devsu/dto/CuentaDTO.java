package com.challenge.devsu.dto;

import lombok.Data;

@Data
public class CuentaDTO {

    private String numero;

    private Long tipoCuentaId;

    private Double saldoInicial;

    private Boolean estado;

    private Long clienteId;
}
