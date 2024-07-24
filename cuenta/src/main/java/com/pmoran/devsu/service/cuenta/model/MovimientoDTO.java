package com.pmoran.devsu.service.cuenta.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pmoran.devsu.service.cuenta.constant.TipoCuentaEnum;
import com.pmoran.devsu.service.cuenta.util.MessageUtility;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovimientoDTO extends BaseDTO {

    private String fecha;

    private String cliente;

    @NotNull(message = MessageUtility.CUENTA_MODEL_CUENTA_EMPTY)
    @NotEmpty(message = MessageUtility.CUENTA_MODEL_CUENTA_EMPTY)
    private String cuenta;

    private TipoCuentaEnum tipo;

    @NotNull(message = MessageUtility.MOVIMIENTO_MODEL_VALOR_EMPTY)
    private BigDecimal monto;

    private String movimiento;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public TipoCuentaEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoCuentaEnum tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }
}
