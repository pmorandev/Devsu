package com.pmoran.devsu.service.cuenta.repository;

import com.pmoran.devsu.service.cuenta.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CuentaRepository extends JpaRepository<Cuenta, String> {

    List<Cuenta> findAllByClienteId(Long clienteId);

}
