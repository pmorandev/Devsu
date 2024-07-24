package com.pmoran.devsu.service.cuenta.converter;

import com.pmoran.devsu.service.cuenta.constant.TipoCuentaEnum;
import com.pmoran.devsu.service.cuenta.entity.Cuenta;
import com.pmoran.devsu.service.cuenta.model.CuentaDTO;
import org.springframework.stereotype.Component;

@Component
public class CuentaConverter extends BaseConverter<Cuenta, CuentaDTO> {
    @Override
    public Cuenta fromDTO(CuentaDTO dto) {
        Cuenta entity = new Cuenta();
        entity.setCuenta(dto.getCuenta());
        entity.setClienteId(dto.getClienteId());
        entity.setTipo(dto.getTipo().getValue());
        entity.setSaldoDisponible(dto.getSaldoDisponible());
        entity.setEstado(dto.getEstado());
        entity.setSaldoInicial(dto.getSaldoInicial());
        entity.setClienteId(dto.getClienteId());
        return entity;
    }

    @Override
    public CuentaDTO fromEntity(Cuenta entity) {
        CuentaDTO dto = new CuentaDTO();
        dto.setCuenta(entity.getCuenta());
        dto.setClienteId(entity.getClienteId());
        dto.setEstado(entity.getEstado());
        dto.setTipo(TipoCuentaEnum.valueOfString(entity.getTipo()));
        dto.setSaldoDisponible(entity.getSaldoDisponible());
        dto.setSaldoInicial(entity.getSaldoInicial());
        return dto;
    }
}
