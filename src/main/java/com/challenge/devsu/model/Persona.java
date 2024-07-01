package com.challenge.devsu.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Persona {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native")
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="genero")
    private String genero;

    @Column(name="edad")
    private Integer edad;

    @Column(name="identificacion")
    private String identificacion;

    @Column(name="direccion")
    private String direccion;

    @Column(name="telefono")
    private String telefono;

    public Persona(){
    }

    public Persona(String nombre, String genero, Integer edad, String identificacion, String direccion, String telefono) {
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
    }
}
