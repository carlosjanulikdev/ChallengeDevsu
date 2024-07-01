package com.challenge.devsu.dto;

import lombok.Data;

@Data
public class ClienteDTO {

    private String nombre;

    private String genero;

    private Integer edad;

    private String identificacion;

    private String direccion;

    private String telefono;

    private String contrasenia;

    private Boolean estado;
}
