package com.pmoran.devsu.service.cuenta.service.impl;

import com.pmoran.devsu.service.cuenta.converter.CuentaConverter;
import com.pmoran.devsu.service.cuenta.entity.Cuenta;
import com.pmoran.devsu.service.cuenta.error.ResourceDuplicationException;
import com.pmoran.devsu.service.cuenta.error.ResourceNotFoundException;
import com.pmoran.devsu.service.cuenta.integration.ClienteRestService;
import com.pmoran.devsu.service.cuenta.integration.model.ClienteDTO;
import com.pmoran.devsu.service.cuenta.model.CuentaDTO;
import com.pmoran.devsu.service.cuenta.repository.CuentaRepository;
import com.pmoran.devsu.service.cuenta.service.CuentaService;
import com.pmoran.devsu.service.cuenta.util.MessageUtility;
import org.springframework.stereotype.Service;

@Service
public class CuentaServiceImpl implements CuentaService {

    private ClienteRestService clienteRestService;

    private CuentaRepository cuentaRepository;

    private CuentaConverter converter;

    public CuentaServiceImpl(ClienteRestService clienteRestService, CuentaRepository cuentaRepository, CuentaConverter converter) {
        this.clienteRestService = clienteRestService;
        this.cuentaRepository = cuentaRepository;
        this.converter = converter;
    }

    @Override
    public CuentaDTO create(CuentaDTO cuenta) throws ResourceDuplicationException, ResourceNotFoundException {
        if(!cuentaRepository.existsById(cuenta.getCuenta())) {
            ClienteDTO clientInfo = getClienteInfo(cuenta.getClienteId());
            Cuenta newCuenta = converter.fromDTO(cuenta);
            newCuenta.setSaldoDisponible(newCuenta.getSaldoInicial());
            newCuenta = cuentaRepository.save(newCuenta);
            cuenta = converter.fromEntity(newCuenta);
            cuenta.setCliente(clientInfo.getNombre());
            return cuenta;
        } else {
            throw new ResourceDuplicationException(String.format(MessageUtility.RESOURCE_DUPLICATION_ERROR, cuenta.getCuenta()));
        }
    }

    @Override
    public CuentaDTO update(CuentaDTO cuenta, String cuentaId) throws ResourceNotFoundException {
        Cuenta entity = getCuentaInfo(cuentaId);
        entity.setEstado(cuenta.getEstado());
        entity.setTipo(cuenta.getTipo().getValue());
        return converter.fromEntity(entity);
    }

    @Override
    public CuentaDTO delete(String cuentaId) throws ResourceNotFoundException {
        Cuenta entity = getCuentaInfo(cuentaId);
        cuentaRepository.deleteById(entity.getCuenta());
        return converter.fromEntity(entity);
    }

    @Override
    public CuentaDTO getCuenta(String cuentaId) throws ResourceNotFoundException {
        Cuenta entity = getCuentaInfo(cuentaId);
        ClienteDTO clientInfo = getClienteInfo(entity.getClienteId());
        CuentaDTO cuentaDTO = converter.fromEntity(entity);
        cuentaDTO.setCliente(clientInfo.getNombre());
        return cuentaDTO;
    }

    private ClienteDTO getClienteInfo(Long clienteId) {
        return clienteRestService.getClienteInfo(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(MessageUtility.CUENTA_MODEL_CLIENTE_NOT_FOUND, clienteId)));
    }

    private Cuenta getCuentaInfo(String cuenta) {
        return cuentaRepository.findById(cuenta)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(MessageUtility.RESOURCE_NOT_FOUND, cuenta)));
    }

}
