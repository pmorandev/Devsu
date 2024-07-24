package com.pmoran.devsu.service.cuenta.integration.impl;

import com.pmoran.devsu.service.cuenta.integration.ClienteRestService;
import com.pmoran.devsu.service.cuenta.integration.model.ClienteDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class ClienteRestServiceImpl implements ClienteRestService {

    @Value("${service.integration.cliente.url}")
    private String clienteRestServiceURL;

    private RestTemplate restTemplate;

    public ClienteRestServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Optional<ClienteDTO> getClienteInfo(Long clienteId) {
        try {
            String clienteInfoURL = String.format("%s/%s", clienteRestServiceURL , clienteId);
            ResponseEntity<ClienteDTO> response = restTemplate.exchange(clienteInfoURL, HttpMethod.GET, null, ClienteDTO.class);
            if(response.getStatusCode().is2xxSuccessful()) {
                return Optional.of(response.getBody());
            } else {
                return Optional.empty();
            }
        } catch (RestClientException ex) {
            return Optional.empty();
        }
    }
}
