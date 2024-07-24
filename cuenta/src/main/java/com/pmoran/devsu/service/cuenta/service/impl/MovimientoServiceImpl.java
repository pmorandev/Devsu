package com.pmoran.devsu.service.cuenta.service.impl;

import com.pmoran.devsu.service.cuenta.converter.MovimientoConverter;
import com.pmoran.devsu.service.cuenta.entity.Cuenta;
import com.pmoran.devsu.service.cuenta.entity.Movimiento;
import com.pmoran.devsu.service.cuenta.error.ResourceNotFoundException;
import com.pmoran.devsu.service.cuenta.integration.ClienteRestService;
import com.pmoran.devsu.service.cuenta.integration.model.ClienteDTO;
import com.pmoran.devsu.service.cuenta.model.MovimientoDTO;
import com.pmoran.devsu.service.cuenta.repository.CuentaRepository;
import com.pmoran.devsu.service.cuenta.repository.MovimientoRepository;
import com.pmoran.devsu.service.cuenta.service.MovimientoService;
import com.pmoran.devsu.service.cuenta.util.MessageUtility;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    private CuentaRepository cuentaRepository;

    private MovimientoRepository movimientoRepository;

    private MovimientoConverter converter;

    private ClienteRestService clienteRestService;

    public MovimientoServiceImpl(CuentaRepository cuentaRepository, MovimientoRepository movimientoRepository,
                                 MovimientoConverter converter, ClienteRestService clienteRestService
    ) {
        this.cuentaRepository = cuentaRepository;
        this.movimientoRepository = movimientoRepository;
        this.converter = converter;
        this.clienteRestService = clienteRestService;
    }

    @Override
    @Transactional
    public MovimientoDTO create(MovimientoDTO movimientoDTO) throws ResourceNotFoundException, IllegalArgumentException {
        if(movimientoDTO.getMonto().compareTo(BigDecimal.ZERO) == 0) throw new IllegalArgumentException(MessageUtility.MOVIMIENTO_MODEL_VALOR_ZERO);
        Cuenta cuenta = getCuentaInfo(movimientoDTO.getCuenta());
        Movimiento newEntity = converter.fromDTO(movimientoDTO);
        BigDecimal newSaldo = cuenta.getSaldoDisponible().add(movimientoDTO.getMonto());
        if(newSaldo.compareTo(BigDecimal.ZERO) > 0) {
            newEntity.setCuenta(cuenta);
            newEntity.setSaldoDisponible(newSaldo);
            newEntity = movimientoRepository.save(newEntity);
            cuenta.setSaldoDisponible(newSaldo);
            return converter.fromEntity(newEntity);
        } else {
            throw new IllegalArgumentException(MessageUtility.MOVIMIENTO_VALOR_FAILED_TRANSACTION);
        }
    }

    @Override
    public List<MovimientoDTO> getMovimientos(LocalDate fechaInicio, LocalDate fechaFinal, Long clienteId) {
        ClienteDTO clientInfo = getClienteInfo(clienteId);
        List<Cuenta> cuentasCliente = getCuentasByCliente(clientInfo.getId());
        if(cuentasCliente.size() > 0) {
            LocalDateTime start = fechaInicio.atTime(LocalTime.MIN);
            LocalDateTime end = fechaFinal.atTime(LocalTime.MAX);
            List<MovimientoDTO> report = cuentasCliente.stream().flatMap((c) -> {
                List<Movimiento> mov = movimientoRepository.findAllByCuentaAndDateRange(c, start, end);
                if(mov.size() > 0) return mov.stream();
                return Stream.empty();
            }).map(converter::fromEntity).map((m) -> {
                m.setCliente(clientInfo.getNombre());
                return m;
            }).collect(Collectors.toList());
            report.sort(Comparator.comparing(MovimientoDTO::getFecha));
            return report;
        }
        return new ArrayList<>();
    }

    private Cuenta getCuentaInfo(String cuenta) {
        return cuentaRepository.findById(cuenta)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(MessageUtility.RESOURCE_NOT_FOUND, cuenta)));
    }

    private ClienteDTO getClienteInfo(Long clienteId) {
        return clienteRestService.getClienteInfo(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException(MessageUtility.RESOURCE_NOT_FOUND.formatted(clienteId)));
    }

    private List<Cuenta> getCuentasByCliente(Long clienteId) {
        return cuentaRepository.findAllByClienteId(clienteId);
    }

}
