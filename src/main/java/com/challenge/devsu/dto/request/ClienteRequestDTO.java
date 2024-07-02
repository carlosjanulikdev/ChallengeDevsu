package com.challenge.devsu.dto.request;

import lombok.Data;

@Data
public class ClienteRequestDTO {

    private String nombre;

    private String genero;

    private Integer edad;

    private String identificacion;

    private String direccion;

    private String telefono;

    private String contrasenia;

    private Boolean estado;
}
