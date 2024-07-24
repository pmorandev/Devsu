package com.pmoran.devsu.service.cliente.service;

import com.pmoran.devsu.service.cliente.constant.GeneroEnum;
import com.pmoran.devsu.service.cliente.converter.ClienteConverter;
import com.pmoran.devsu.service.cliente.entity.Cliente;
import com.pmoran.devsu.service.cliente.error.ResourceDuplicationException;
import com.pmoran.devsu.service.cliente.error.ResourceNotFoundException;
import com.pmoran.devsu.service.cliente.model.ClienteDTO;
import com.pmoran.devsu.service.cliente.repository.ClienteRepository;
import com.pmoran.devsu.service.cliente.repository.PersonaRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

@SpringBootTest
public class ClienteServiceTest {

    @MockBean
    private PersonaRepository personaRepository;

    @MockBean
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteConverter converter;

    @Test
    public void testFailedCreateClienteIdentityDuplication() {
        ClienteDTO newCliente = getNewFakeClienteDTO(Optional.empty());
        doReturn(Boolean.TRUE).when(personaRepository).existsByIdentidad(newCliente.getIdentidad());

        assertThrows(ResourceDuplicationException.class, () -> clienteService.create(newCliente));
    }

    @Test
    public void testFailedUpdateWhenClientIdNotFound() {
        ClienteDTO fakeClient = getNewFakeClienteDTO(Optional.empty());
        doReturn(Optional.empty()).when(clienteRepository).findById(anyLong());

        assertThrows(ResourceNotFoundException.class,  () -> clienteService.update(fakeClient, 1_000_000L));
    }

    @Test
    public void testFailedClientDelete() {
        doReturn(Optional.empty()).when(clienteRepository).findById(anyLong());
        assertThrows(ResourceNotFoundException.class,  () -> clienteService.delete(1_000_000L));
    }

    @Test
    public void testFailedRetrieveClient() {
        doReturn(Optional.empty()).when(clienteRepository).findById(anyLong());
        assertThrows(ResourceNotFoundException.class,  () -> clienteService.getCliente(1_000_000L));
    }

    private ClienteDTO getNewFakeClienteDTO(Optional<String> identidad) {
        ClienteDTO newCliente = new ClienteDTO();
        newCliente.setIdentidad(identidad.orElse("123456789"));
        newCliente.setEstado(true);
        newCliente.setPassword("12345");
        newCliente.setEdad(34);
        newCliente.setTelefono("1234");
        newCliente.setGenero(GeneroEnum.MASCULINO);
        newCliente.setDireccion("afasdadad");
        newCliente.setNombre("Fake Nombre");
        return newCliente;
    }

    private List<ClienteDTO> getListFakeClients() {
        List<ClienteDTO> clientes = new ArrayList<>(11);
        for(int i = 1; i <= 11; i++) {
            clientes.add(getNewFakeClienteDTO(Optional.of("123456789" + i)));
        }
        return clientes;
    }

}
