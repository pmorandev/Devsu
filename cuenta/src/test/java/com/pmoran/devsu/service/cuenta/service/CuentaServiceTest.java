package com.pmoran.devsu.service.cuenta.service;

import com.pmoran.devsu.service.cuenta.converter.CuentaConverter;
import com.pmoran.devsu.service.cuenta.error.ResourceDuplicationException;
import com.pmoran.devsu.service.cuenta.error.ResourceNotFoundException;
import com.pmoran.devsu.service.cuenta.integration.ClienteRestService;
import com.pmoran.devsu.service.cuenta.integration.impl.ClienteRestServiceImpl;
import com.pmoran.devsu.service.cuenta.model.CuentaDTO;
import com.pmoran.devsu.service.cuenta.repository.CuentaRepository;
import com.pmoran.devsu.service.cuenta.service.impl.CuentaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ClienteRestServiceImpl.class, CuentaRepository.class, CuentaConverter.class,
        CuentaServiceImpl.class})
public class CuentaServiceTest {

    @MockBean
    private ClienteRestService restService;

    @MockBean
    private CuentaRepository cuentaRepository;

    @SpyBean
    private CuentaConverter converter;

    @Autowired
    private CuentaService cuentaService;

    @Test
    public void testCreateDuplciatedCuenta() {
        CuentaDTO dtoMock = mock(CuentaDTO.class);
        when(dtoMock.getCuenta()).thenReturn("123");
        when(cuentaRepository.existsById("123")).thenReturn(Boolean.TRUE);

        assertThrowsExactly(ResourceDuplicationException.class, () -> cuentaService.create(dtoMock));
    }

    @Test
    public void testCreatedCuentaClienteNotFound() {
        CuentaDTO dtoMock = mock(CuentaDTO.class);
        when(cuentaRepository.existsById(anyString())).thenReturn(Boolean.FALSE);
        when(restService.getClienteInfo(anyLong())).thenReturn(Optional.empty());

        assertThrowsExactly(ResourceNotFoundException.class, () -> cuentaService.create(dtoMock));
    }

}
