package com.pmoran.devsu.service.cliente.repository;

import com.pmoran.devsu.service.cliente.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, String> {

    public boolean existsByIdentidad(String identidad);

}
