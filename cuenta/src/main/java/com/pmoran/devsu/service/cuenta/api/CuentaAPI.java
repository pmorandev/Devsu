package com.pmoran.devsu.service.cuenta.api;

import com.pmoran.devsu.service.cuenta.error.ResourceDuplicationException;
import com.pmoran.devsu.service.cuenta.error.ResourceNotFoundException;
import com.pmoran.devsu.service.cuenta.model.CuentaDTO;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(CuentaAPI.BASE_URL)
public interface CuentaAPI {
    final String BASE_URL = "/cuentas";

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CuentaDTO> getCuenta(@PathVariable("id") String cuentaId) throws ResourceNotFoundException;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CuentaDTO> createCuenta(@Valid @RequestBody CuentaDTO cuenta) throws ResourceDuplicationException, ResourceNotFoundException;

    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CuentaDTO> updateCuenta(@PathVariable("id") String cuentaId, @Valid @RequestBody CuentaDTO cuenta) throws ResourceNotFoundException;

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CuentaDTO> deleteCuenta(@PathVariable("id") String cuentaId) throws ResourceNotFoundException;

}
