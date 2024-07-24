package com.pmoran.devsu.service.cliente.api;

import com.pmoran.devsu.service.cliente.error.ResourceNotFoundException;
import com.pmoran.devsu.service.cliente.model.ClienteDTO;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ClienteAPI.BASE_URL)
public interface ClienteAPI {

    final String BASE_URL = "/clientes";

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ClienteDTO> getClient(@PathVariable("id") Long id) throws ResourceNotFoundException;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ClienteDTO>> getClients(@RequestParam(name = "page", defaultValue = "0") Integer page, @RequestParam(name = "size", defaultValue = "10") Integer size);

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ClienteDTO> createClient(@Valid @RequestBody ClienteDTO clienteDTO);

    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ClienteDTO> updateClient(@PathVariable("id") Long id, @Valid @RequestBody ClienteDTO clienteDTO) throws ResourceNotFoundException;

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ClienteDTO> deleteClient(@PathVariable("id") Long id) throws ResourceNotFoundException;
}
