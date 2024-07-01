package com.challenge.devsu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Data
@Table(name="cliente")
@DiscriminatorValue("CLIENTE")
public class Cliente extends Persona {

    @Column(name="contrasenia")
    private String contrasenia;

    @Column(name="estado")
    private Boolean estado;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Cuenta> cuentas;


    public Cliente(){

    }

    public Cliente(String contrasenia, Boolean estado) {
        this.contrasenia = contrasenia;
        this.estado = estado;
    }

    public Cliente(String nombre, String genero, Integer edad, String identificacion, String direccion, String telefono,
                   String contrasenia, Boolean estado) {
        super(nombre, genero, edad, identificacion, direccion, telefono);
        this.contrasenia = contrasenia;
        this.estado = estado;
    }
}
