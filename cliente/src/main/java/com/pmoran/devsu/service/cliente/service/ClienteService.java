package com.pmoran.devsu.service.cliente.service;

import com.pmoran.devsu.service.cliente.error.ResourceDuplicationException;
import com.pmoran.devsu.service.cliente.error.ResourceNotFoundException;
import com.pmoran.devsu.service.cliente.model.ClienteDTO;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    ClienteDTO create(ClienteDTO newCliente) throws ResourceDuplicationException;

    ClienteDTO update(ClienteDTO cliente, Long clientId) throws ResourceNotFoundException;

    ClienteDTO delete(Long clientId) throws ResourceNotFoundException;

    ClienteDTO getCliente(Long clientId) throws ResourceNotFoundException;

    List<ClienteDTO> getClientes(Optional<Integer> page, Optional<Integer> size);

}
