package com.pmoran.devsu.service.cuenta.repository;

import com.pmoran.devsu.service.cuenta.entity.Cuenta;
import com.pmoran.devsu.service.cuenta.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {

    @Query("SELECT m FROM Movimiento m " +
            "WHERE m.cuenta = :cuenta " +
            "AND m.fecha BETWEEN :startDate AND :endDate")
    List<Movimiento> findAllByCuentaAndDateRange(
            @Param("cuenta") Cuenta cuenta,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate);

}
