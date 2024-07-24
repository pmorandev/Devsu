package com.pmoran.devsu.service.cuenta.service;

import com.pmoran.devsu.service.cuenta.error.ResourceNotFoundException;
import com.pmoran.devsu.service.cuenta.model.MovimientoDTO;

import java.time.LocalDate;
import java.util.List;

public interface MovimientoService {

    MovimientoDTO create(MovimientoDTO movimientoDTO) throws ResourceNotFoundException, IllegalArgumentException;

    List<MovimientoDTO> getMovimientos(LocalDate fechaInicio, LocalDate fechaFinal, Long clienteId);

}
