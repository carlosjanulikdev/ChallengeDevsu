package com.challenge.devsu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Data
@Table(name="movimiento")
public class Movimiento {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native")
    private Long id;

    @Column(name="fecha")
    private Date fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tipo_movimiento_id", nullable=false)
    private TipoMovimiento tipoMovimiento;

    @Column(name="valor")
    private Double valor;

    @Column(name="saldo")
    private Double saldo;

    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private Cuenta cuenta;
}
