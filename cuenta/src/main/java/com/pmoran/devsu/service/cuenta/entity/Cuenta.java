package com.pmoran.devsu.service.cuenta.entity;

import jakarta.persistence.*;

import java.util.List;
import java.math.BigDecimal;

@Entity
@Table(name = "Cuentas")
public class Cuenta extends BaseEntity {

    @Id
    @Column(name = "Cuenta", unique = true, nullable = false)
    private String cuenta;

    @Column(name = "Tipo", nullable = false, length = 255)
    private String tipo;

    @Column(name = "SaldoInicial", nullable = false)
    private BigDecimal saldoInicial;

    @Column(name = "Estado", nullable = false)
    private Boolean estado;

    @Column(name = "Cliente_Id", nullable = false)
    private Long clienteId;

    @Column(name = "SaldoDisponible", nullable = false)
    private BigDecimal saldoDisponible;

    @OneToMany(mappedBy = "cuenta", fetch = FetchType.LAZY)
    private List<Movimiento> movimientos;

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(BigDecimal saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public BigDecimal getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(BigDecimal saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }
}
