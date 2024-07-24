package com.pmoran.devsu.service.cliente.repository;

import com.pmoran.devsu.service.cliente.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
