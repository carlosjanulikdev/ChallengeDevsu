package com.challenge.devsu.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ReporteEstadoCuentaResponseDTO {

    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("Fecha")
    private Date fecha;

    @JsonProperty("Cliente")
    private String cliente;

    @JsonProperty("Numero Cuenta")
    private String numeroCuenta;

    @JsonProperty("Tipo")
    private String tipo;

    @JsonProperty("Saldo Inicial")
    private Double saldoInicial;

    @JsonProperty("Estado")
    private Boolean estado;

    @JsonProperty("Movimiento")
    private Double movimiento;

    @JsonProperty("Saldo Disponible")
    private Double saldoDisponible;
}
