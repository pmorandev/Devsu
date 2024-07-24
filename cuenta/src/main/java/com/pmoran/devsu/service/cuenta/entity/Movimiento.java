package com.pmoran.devsu.service.cuenta.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Movimientos")
public class Movimiento extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    private Long id;

    @Column(name = "Fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "Valor", nullable = false)
    private BigDecimal valor;

    @Column(name = "SaldoDisponible", nullable = false)
    private BigDecimal saldoDisponible;

    @ManyToOne
    @JoinColumn(name = "Cuenta_Id", nullable = false)
    private Cuenta cuenta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(BigDecimal saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
