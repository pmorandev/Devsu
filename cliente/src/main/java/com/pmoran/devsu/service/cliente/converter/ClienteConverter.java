package com.pmoran.devsu.service.cliente.converter;

import com.pmoran.devsu.service.cliente.constant.GeneroEnum;
import com.pmoran.devsu.service.cliente.entity.Cliente;
import com.pmoran.devsu.service.cliente.entity.Persona;
import com.pmoran.devsu.service.cliente.model.ClienteDTO;
import org.springframework.stereotype.Component;

@Component
public class ClienteConverter extends BaseConverter<Cliente, ClienteDTO> {


    @Override
    public Cliente fromDTO(ClienteDTO dto) {
        Cliente entity = new Cliente();
        Persona data = new Persona();
        data.setIdentidad(dto.getIdentidad());
        data.setNombre(dto.getNombre());
        data.setDireccion(dto.getDireccion());
        data.setTelefono(dto.getTelefono());
        data.setGenero(dto.getGenero().getValue());
        data.setEdad(dto.getEdad());
        entity.setData(data);
        entity.setPassword(dto.getPassword());
        entity.setEstado(dto.getEstado());
        return entity;
    }

    @Override
    public ClienteDTO fromEntity(Cliente entity) {
        ClienteDTO dto = new ClienteDTO();
        Persona data = entity.getData();
        dto.setId(entity.getId());
        dto.setIdentidad(data.getIdentidad());
        dto.setNombre(data.getNombre());
        dto.setDireccion(data.getDireccion());
        dto.setTelefono(data.getTelefono());
        dto.setEdad(data.getEdad());
        dto.setGenero(GeneroEnum.valueOfString(data.getGenero()));
        dto.setPassword(entity.getPassword());
        dto.setEstado(entity.getEstado());
        return dto;
    }
}
