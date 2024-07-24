package com.pmoran.devsu.service.cuenta.service;

import com.pmoran.devsu.service.cuenta.converter.MovimientoConverter;
import com.pmoran.devsu.service.cuenta.entity.Cuenta;
import com.pmoran.devsu.service.cuenta.integration.ClienteRestService;
import com.pmoran.devsu.service.cuenta.model.MovimientoDTO;
import com.pmoran.devsu.service.cuenta.repository.CuentaRepository;
import com.pmoran.devsu.service.cuenta.repository.MovimientoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class MovimientoServiceTest {

    @MockBean
    private ClienteRestService restService;

    @MockBean
    private CuentaRepository cuentaRepository;

    @MockBean
    private MovimientoRepository movimientoRepository;

    @SpyBean
    private MovimientoConverter converter;

    @Autowired
    private MovimientoService movimientoService;

    @Test
    public void testFailedBadMontoMovimiento() {
        MovimientoDTO dto = getTestMovimiento(BigDecimal.ZERO, "1234567890");

        assertThrows(IllegalArgumentException.class, () -> movimientoService.create(dto));
    }

    @Test
    public void testFailedRetiroGreaterMovimiento() {
        MovimientoDTO dto = getTestMovimiento(BigDecimal.valueOf(-10_000_000L), "1234567890");
        Cuenta mockCuenta = mock(Cuenta.class);
        doReturn(Optional.of(mockCuenta)).when(cuentaRepository).findById(anyString());
        when(mockCuenta.getSaldoDisponible()).thenReturn(BigDecimal.ONE);

        assertThrows(IllegalArgumentException.class, () -> movimientoService.create(dto));
    }

    private MovimientoDTO getTestMovimiento(BigDecimal monto, String cuenta) {
        MovimientoDTO dto = new MovimientoDTO();
        dto.setMonto(monto);
        dto.setCuenta(cuenta);
        return dto;
    }

}
