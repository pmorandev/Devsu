package com.pmoran.devsu.service.cuenta.api;

import com.pmoran.devsu.service.cuenta.error.ResourceNotFoundException;
import com.pmoran.devsu.service.cuenta.model.MovimientoDTO;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(MovimientoAPI.BASE_URL)
public interface MovimientoAPI {

    final String BASE_URL = "/movimientos";

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<MovimientoDTO> createMovimiento(@Valid @RequestBody MovimientoDTO movimientoDTO) throws ResourceNotFoundException, IllegalArgumentException;

}
