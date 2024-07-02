package com.challenge.devsu.dto.response;

import lombok.Data;

@Data
public class CuentaResponseDTO {

    private Long id;

    private String numero;

    private Double saldoInicial;

    private Boolean estado;

    private CuentaClienteResponseDTO cliente;
}
