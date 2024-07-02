package com.challenge.devsu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Data
@Table(name="cuenta")
public class Cuenta {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native")
    private Long id;

    @Column(name="numero")
    private String numero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tipo_cuenta_id", nullable=false)
    private TipoCuenta tipoCuenta;

    @Column(name="saldo_inicial")
    private Double saldoInicial;

    @Column(name="estado")
    private Boolean estado;

    @JsonIgnoreProperties("cuentas")
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
    private List<Movimiento> movimientos;

    public Cuenta(){

    }

    public Cuenta(String numero, TipoCuenta tipoCuenta, Double saldoInicial, Boolean estado, Cliente cliente) {
        this.numero = numero;
        this.tipoCuenta = tipoCuenta;
        this.saldoInicial = saldoInicial;
        this.estado = estado;
        this.cliente = cliente;
    }
}
