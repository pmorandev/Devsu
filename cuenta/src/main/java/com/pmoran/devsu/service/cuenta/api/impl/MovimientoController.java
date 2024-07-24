package com.pmoran.devsu.service.cuenta.api.impl;

import com.pmoran.devsu.service.cuenta.api.MovimientoAPI;
import com.pmoran.devsu.service.cuenta.error.ResourceNotFoundException;
import com.pmoran.devsu.service.cuenta.model.MovimientoDTO;
import com.pmoran.devsu.service.cuenta.service.MovimientoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovimientoController implements MovimientoAPI {

    private MovimientoService movimientoService;

    public MovimientoController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }

    @Override
    public ResponseEntity<MovimientoDTO> createMovimiento(MovimientoDTO movimientoDTO) throws ResourceNotFoundException, IllegalArgumentException {
        return ResponseEntity.ok(movimientoService.create(movimientoDTO));
    }
}
