package com.pmoran.devsu.service.cuenta.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pmoran.devsu.service.cuenta.constant.TipoCuentaEnum;
import com.pmoran.devsu.service.cuenta.util.MessageUtility;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;

public class CuentaDTO extends BaseDTO {

    @NotNull(message = MessageUtility.CUENTA_MODEL_CUENTA_EMPTY)
    @NotEmpty(message = MessageUtility.CUENTA_MODEL_CUENTA_EMPTY)
    @Pattern(regexp = "^\\d{10}$", message = MessageUtility.CUENTA_MODEL_CUENTA_NOT_MATCH)
    private String cuenta;

    @NotNull(message = MessageUtility.CUENTA_MODEL_CLIENTE_EMPTY)
    private Long clienteId;

    private String cliente;

    @NotNull(message = MessageUtility.CUENTA_MODEL_TIPO_EMPTY)
    @JsonProperty("tipo")
    private TipoCuentaEnum tipo;

    @NotNull(message = MessageUtility.CUENTA_MODEL_ESTADO_EMPTY)
    private Boolean estado;

    @NotNull(message = MessageUtility.CUENTA_MODEL_SALDO_INICIAL_EMPTY)
    @Min(message = MessageUtility.CUENTA_MODEL_SALDO_INICIAL_NOT_MATCH, value = 0L)
    private BigDecimal saldoInicial;

    private BigDecimal saldoDisponible;

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public TipoCuentaEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoCuentaEnum tipo) {
        this.tipo = tipo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public BigDecimal getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(BigDecimal saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public BigDecimal getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(BigDecimal saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }
}
