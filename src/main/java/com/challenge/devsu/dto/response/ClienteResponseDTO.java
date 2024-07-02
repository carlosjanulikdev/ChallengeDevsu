package com.challenge.devsu.dto.response;

import lombok.Data;

@Data
public class ClienteResponseDTO {

    private Long id;

    private String nombre;

    private String genero;

    private Integer edad;

    private String identificacion;

    private String direccion;

    private String telefono;

}
