package com.pmoran.devsu.service.cuenta.service;

import com.pmoran.devsu.service.cuenta.error.ResourceDuplicationException;
import com.pmoran.devsu.service.cuenta.error.ResourceNotFoundException;
import com.pmoran.devsu.service.cuenta.model.CuentaDTO;

public interface CuentaService {

    CuentaDTO create(CuentaDTO cuenta) throws ResourceDuplicationException, ResourceNotFoundException;

    CuentaDTO update(CuentaDTO cuenta, String cuentaId) throws ResourceNotFoundException;

    CuentaDTO delete(String cuentaId) throws ResourceNotFoundException;

    CuentaDTO getCuenta(String cuentaId) throws ResourceNotFoundException;

}
