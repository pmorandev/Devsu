package com.pmoran.devsu.service.cuenta.converter;

import com.pmoran.devsu.service.cuenta.entity.BaseEntity;
import com.pmoran.devsu.service.cuenta.model.BaseDTO;

import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseConverter<E extends BaseEntity, D extends BaseDTO> {

    public abstract E fromDTO(D dto);

    public abstract D fromEntity(E entity);

    public List<E> fromDTOs(List<D> dtos) {
        return dtos.stream()
                .map(this::fromDTO)
                .collect(Collectors.toList());
    }

    public List<D> fromEntities(List<E> entities) {
        return entities.stream()
                .map(this::fromEntity)
                .collect(Collectors.toList());
    }

}
