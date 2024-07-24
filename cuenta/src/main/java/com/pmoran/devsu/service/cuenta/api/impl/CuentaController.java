package com.pmoran.devsu.service.cuenta.api.impl;

import com.pmoran.devsu.service.cuenta.api.CuentaAPI;
import com.pmoran.devsu.service.cuenta.error.ResourceDuplicationException;
import com.pmoran.devsu.service.cuenta.error.ResourceNotFoundException;
import com.pmoran.devsu.service.cuenta.model.CuentaDTO;
import com.pmoran.devsu.service.cuenta.service.CuentaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CuentaController implements CuentaAPI {

    private CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @Override
    public ResponseEntity<CuentaDTO> getCuenta(String cuentaId) throws ResourceNotFoundException {
        return ResponseEntity.ok(cuentaService.getCuenta(cuentaId));
    }

    @Override
    public ResponseEntity<CuentaDTO> createCuenta(CuentaDTO cuenta) throws ResourceDuplicationException, ResourceNotFoundException {
        return ResponseEntity.ok(cuentaService.create(cuenta));
    }

    @Override
    public ResponseEntity<CuentaDTO> updateCuenta(String cuentaId, CuentaDTO cuenta) throws ResourceNotFoundException {
        return ResponseEntity.ok(cuentaService.update(cuenta, cuentaId));
    }

    @Override
    public ResponseEntity<CuentaDTO> deleteCuenta(String cuentaId) throws ResourceNotFoundException {
        return ResponseEntity.ok(cuentaService.delete(cuentaId));
    }
}
