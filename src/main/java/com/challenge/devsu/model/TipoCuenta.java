package com.challenge.devsu.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Data
@Table(name="tipo_cuenta")
public class TipoCuenta {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native")
    private Long id;

    @Column(name="descripcion")
    @NotNull(message = "La descripcion es obligatoria")
    private String descripcion;

    @Override
    public String toString() {
        return "TipoCuenta{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

}
