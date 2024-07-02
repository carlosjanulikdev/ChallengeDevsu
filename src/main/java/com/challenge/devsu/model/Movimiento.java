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

    @JsonIgnoreProperties("movimientos")
    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private Cuenta cuenta;

    public Movimiento(){

    }

    public Movimiento(Date fecha, TipoMovimiento tipoMovimiento, Double valor, Double saldo, Cuenta cuenta) {
        this.fecha = fecha;
        this.tipoMovimiento = tipoMovimiento;
        this.valor = valor;
        this.saldo = saldo;
        this.cuenta = cuenta;
    }
}
