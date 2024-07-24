package com.pmoran.devsu.service.cliente.api.impl;

import com.pmoran.devsu.service.cliente.api.ClienteAPI;
import com.pmoran.devsu.service.cliente.error.ResourceNotFoundException;
import com.pmoran.devsu.service.cliente.model.ClienteDTO;
import com.pmoran.devsu.service.cliente.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController implements ClienteAPI {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Override
    public ResponseEntity<ClienteDTO> getClient(Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(clienteService.getCliente(id));
    }

    @Override
    public ResponseEntity<List<ClienteDTO>> getClients(Integer page, Integer size) {
        return ResponseEntity.ok(clienteService.getClientes(Optional.of(page), Optional.of(size)));
    }

    @Override
    public ResponseEntity<ClienteDTO> createClient(ClienteDTO clienteDTO) {
        return ResponseEntity.ok(clienteService.create(clienteDTO));
    }

    @Override
    public ResponseEntity<ClienteDTO> updateClient(Long id, ClienteDTO clienteDTO) throws ResourceNotFoundException {
        return ResponseEntity.ok(clienteService.update(clienteDTO, id));
    }

    @Override
    public ResponseEntity<ClienteDTO> deleteClient(Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(clienteService.delete(id));
    }
}
