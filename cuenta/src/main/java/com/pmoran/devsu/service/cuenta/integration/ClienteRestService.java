package com.pmoran.devsu.service.cuenta.integration;

import com.pmoran.devsu.service.cuenta.integration.model.ClienteDTO;

import java.util.Optional;

public interface ClienteRestService {

    Optional<ClienteDTO> getClienteInfo(Long clienteId);

}
