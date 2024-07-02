package com.challenge.devsu.dto.request;

import lombok.Data;

@Data
public class CuentaRequestDTO {

    private String numero;

    private Long tipoCuentaId;

    private Double saldoInicial;

    private Boolean estado;

    private Long clienteId;
}
