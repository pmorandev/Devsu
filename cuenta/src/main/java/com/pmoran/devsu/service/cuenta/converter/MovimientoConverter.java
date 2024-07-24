package com.pmoran.devsu.service.cuenta.converter;

import com.pmoran.devsu.service.cuenta.constant.TipoCuentaEnum;
import com.pmoran.devsu.service.cuenta.entity.Movimiento;
import com.pmoran.devsu.service.cuenta.model.MovimientoDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class MovimientoConverter extends BaseConverter<Movimiento, MovimientoDTO> {
    @Override
    public Movimiento fromDTO(MovimientoDTO dto) {
        Movimiento entity = new Movimiento();
        entity.setValor(dto.getMonto());
        entity.setFecha(LocalDateTime.now());
        return entity;
    }

    @Override
    public MovimientoDTO fromEntity(Movimiento entity) {
        MovimientoDTO dto = new MovimientoDTO();
        dto.setCuenta(entity.getCuenta().getCuenta());
        dto.setFecha(entity.getFecha().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        dto.setTipo(TipoCuentaEnum.valueOfString(entity.getCuenta().getTipo()));
        dto.setMonto(entity.getValor());
        dto.setMovimiento(entity.getValor().compareTo(BigDecimal.ZERO) < 0
                ? String.format("Retiro de %s", entity.getValor().abs())
                : String.format("Deposito de %s", entity.getValor()));
        return dto;
    }
}
