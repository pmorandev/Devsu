package com.pmoran.devsu.service.cliente.service.impl;

import com.pmoran.devsu.service.cliente.converter.ClienteConverter;
import com.pmoran.devsu.service.cliente.entity.Cliente;
import com.pmoran.devsu.service.cliente.entity.Persona;
import com.pmoran.devsu.service.cliente.error.ResourceDuplicationException;
import com.pmoran.devsu.service.cliente.error.ResourceNotFoundException;
import com.pmoran.devsu.service.cliente.model.ClienteDTO;
import com.pmoran.devsu.service.cliente.repository.ClienteRepository;
import com.pmoran.devsu.service.cliente.repository.PersonaRepository;
import com.pmoran.devsu.service.cliente.service.ClienteService;
import com.pmoran.devsu.service.cliente.util.MessageUtility;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    private final PersonaRepository personaRepository;

    private final ClienteConverter converter;

    public ClienteServiceImpl(ClienteRepository clienteRepository, PersonaRepository personaRepository, ClienteConverter converter) {
        this.clienteRepository = clienteRepository;
        this.personaRepository = personaRepository;
        this.converter = converter;
    }

    @Override
    @Transactional
    public ClienteDTO create(ClienteDTO newCliente) throws ResourceDuplicationException {
        Cliente newEntity = converter.fromDTO(newCliente);
        newEntity.setData(createNewClienteData(newEntity.getData()));
        newEntity = clienteRepository.save(newEntity);
        return converter.fromEntity(newEntity);
    }

    @Override
    @Transactional
    public ClienteDTO update(ClienteDTO cliente, Long clientId) throws ResourceNotFoundException {
        Cliente entity = getClienteById(clientId);
        entity.setEstado(cliente.getEstado());
        entity.setPassword(cliente.getPassword());
        entity.getData().setEdad(cliente.getEdad());
        entity.getData().setGenero(cliente.getGenero().getValue());
        entity.getData().setTelefono(cliente.getTelefono());
        entity.getData().setNombre(cliente.getNombre());
        entity.getData().setDireccion(cliente.getDireccion());
        return converter.fromEntity(entity);
    }

    @Override
    public ClienteDTO delete(Long clientId) {
        Cliente entity = getClienteById(clientId);
        clienteRepository.deleteById(clientId);
        return converter.fromEntity(entity);
    }

    @Override
    public ClienteDTO getCliente(Long clientId) throws ResourceNotFoundException {
        return converter.fromEntity(getClienteById(clientId));
    }

    @Override
    public List<ClienteDTO> getClientes(Optional<Integer> page, Optional<Integer> size) {
        if(page.isPresent() && size.isPresent()) {
            Pageable pageRequest = PageRequest.of(page.get(), size.get());
            return converter.fromEntities(clienteRepository.findAll(pageRequest).toList());
        } else {
            return converter.fromEntities(clienteRepository.findAll());
        }
    }

    private Persona createNewClienteData(Persona data) throws ResourceDuplicationException {
        Persona entity;
        try {
            if(personaRepository.existsByIdentidad(data.getIdentidad())) {
                throw new ResourceDuplicationException(String.format(MessageUtility.RESOURCE_DUPLICATION_ERROR, data.getIdentidad()));
            }
            entity = personaRepository.save(data);
        } catch (ResourceDuplicationException ex) {
            throw ex;
        }
        return entity;
    }

    private Cliente getClienteById(Long id) throws ResourceNotFoundException {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(MessageUtility.RESOURCE_NOT_FOUND, id)));
    }

}
