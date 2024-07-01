package com.challenge.devsu.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Data
@Table(name="tipo_movimiento")
public class TipoMovimiento {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
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
