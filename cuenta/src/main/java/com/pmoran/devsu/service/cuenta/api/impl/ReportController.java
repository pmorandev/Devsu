package com.pmoran.devsu.service.cuenta.api.impl;

import com.pmoran.devsu.service.cuenta.api.ReportAPI;
import com.pmoran.devsu.service.cuenta.model.MovimientoDTO;
import com.pmoran.devsu.service.cuenta.service.MovimientoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ReportController implements ReportAPI {

    private MovimientoService movimientoService;

    public ReportController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }

    @Override
    public ResponseEntity<List<MovimientoDTO>> getMovimientosByDateAndCliente(LocalDate start, LocalDate end, Long cliente) {
        return ResponseEntity.ok(movimientoService.getMovimientos(start, end, cliente));
    }
}
